package com.dj.ch12_3;
/**��������*/
public class DeadLockTest {
    
    public static void main(String[] args) {
    	//����һ����Դ���������� �ڲ�Ĭ������������ʹ�õ���Դ����
    	ResourceManager resourceManager = new ResourceManager(); 
    	//���߳�
    	CustomerReadThread read = new CustomerReadThread(resourceManager);  
    	//д�߳�
    	CustomerWriteThread write = new CustomerWriteThread(resourceManager,2,4);  
    	
    	//��ʼ��ͣ�Ķ�ȡ��Դ����������Դ������
    	read.start();
    	/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
    	//��ʼ��ͣ������Դ�������е���Դд������
    	write.start();  
	}
}
