package com.dj.ch12_3;
/**���߳�*/
public class CustomerReadThread extends Thread{
	//��Դ�����࣬ͨ�������ÿ��Ե�������ط�������Դ���ж�д  
	private ResourceManager resourceManger;
      
    public CustomerReadThread(ResourceManager resourceManger){  
        this.resourceManger = resourceManger;  
    }  
    //����߳��ฺ��ͣ�Ķ�ȡ��Դ�е�����
    public void run(){  
        while(true){  
            this.resourceManger.read();  
        }  
    }  
}