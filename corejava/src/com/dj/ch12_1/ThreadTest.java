package com.dj.ch12_1;

public class ThreadTest extends Thread{
	
	/*public void run() {
		Thread currentThread = Thread.currentThread();
		for(int i=0;i<10;i++){
			System.out.println("�߳���: "+currentThread.getName());
			System.out.println(i);
			if(i==5){
				try {
					Thread.sleep(2000);  //˭ִ��˭����
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}		
		}
	}*/
	public static void main(String[] args) {
		Thread t = new ThreadTest();
//		System.out.println("main:"+t.getName());
//		System.out.println("main:"+t.getId());
//		t.run();    //���߳�main����ThreadTest���е�run����
		t.start();  //�߳��������̣߳����ƶ�ʱ����
	}
}
