package com.dj.ch12_1;

public class JoinThreadTest extends Thread{
	
	public void run() {
		String name = getName();
		for(int i=0;i<10;i++){
			System.out.println(i+":threadName:"+name);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.println("main start...");
		JoinThreadTest jt = new JoinThreadTest();
		jt.start();
		//main�߳��е�����jt.join()����ômain�̱߳���ȴ�jt����߳̽�������ܽ���
		//A�̵߳���B.join����,��ô����A�߳�Ҫ�ȴ�B�߳����н�������ܽ�������
		jt.join();  //���𡢵ȴ�
		System.out.println("main over...");
	}
}
