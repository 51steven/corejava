package com.dj.ch12_3;
/**��Դ������*/
public class ResourceManager {
	//�����������Դ 
	private Resource resourceA = new Resource();  
    private Resource resourceB = new Resource();  
    
    public ResourceManager(){  
        this.resourceA.setValue(0);  
        this.resourceB.setValue(0);  
    }
    
    /**��Դ�Ķ�ȡ*/
    public int read(){
    	//��ȡA��Դ���ݵ�ʱ��Ҫ����,��ֹ�����ڴ��ڼ��޸���ԴA�е�����
        synchronized(this.resourceA){  
            System.out.println(Thread.currentThread().getName() + "�߳��õ�����Դ resourceA�Ķ�����");  
            
           //��ȡ����Դ���ݵ�ʱ��Ҫ����,��ֹ�����ڴ��ڼ��޸���Դ���е�����
            synchronized(this.resourceB){  
                System.out.println(Thread.currentThread().getName() + "�߳��õ�����Դ resourceB�Ķ�����");  
            }  
            //������������õ��ˣ����Ѷ���ֵ��Ӳ�����
            return this.resourceA.getValue() + this.resourceB.getValue();  
        }  
    }  
    /**��Դ�ĸ�д*/
    public void write(int a,int b){  
    	
    	//д�����Դ���ݵ�ʱ��Ҫ����,��ֹ�����ڴ��ڼ��ȡ��ԴA�е�����(����汻��ȡ����ô����������ݾͲ�׼ȷ��)
        synchronized(this.resourceB){  
            System.out.println(Thread.currentThread().getName() + "�߳��õ�����Դ resourceB �Ķ�����");  
            
           //д��A��Դ���ݵ�ʱ��Ҫ����,��ֹ�����ڴ��ڼ��ȡ��ԴA�е�����(����汻��ȡ����ô����������ݾͲ�׼ȷ��)
            synchronized(this.resourceA){  
                System.out.println(Thread.currentThread().getName() + "�߳��õ�����Դ resourceA �Ķ�����");  
                //������������õ��ˣ�������������ǵ�ֵ
                this.resourceA.setValue(a);  
                this.resourceB.setValue(b);  
            }  
        }  
    } 
}
