package com.dj.ch12_3;
/**д�߳�*/
public class CustomerWriteThread extends Thread{
	//��Դ�����࣬ͨ�������ÿ��Ե�������ط�������Դ���ж�д  
	private ResourceManager resourceManger;
	/**��Ҫд����Դ������  */
    private int a,b;
    public CustomerWriteThread(ResourceManager resourceManger,int a,int b){  
        this.resourceManger = resourceManger;  
        this.a = a;  
        this.b = b;  
    }  
    //����߳��ฺ��ͣ�Ľ�����д�뵽��Դ��
    public void run(){  
        while(true){  
            this.resourceManger.write(a, b);
        }  
    }  
}

