package com.dj.ch12_1;
/**
 * �߳�ͬ��
 * �ο��� http://blog.csdn.net/ghsau/article/details/7424694
 * Java�̵߳��������� �� �ɼ��Ժ������ԡ�ԭ����
 * ����volatileҲ����ʵ���߳�ͬ�������Բο��������volatile
 * */
public class SynchronizedTest {
	public static void main(String[] args) {
		Student s = new Student();
//		Student s2 = new Student();	
		
		Thread t1 = new MyThread(s);
		Thread t2 = new MyThread(s);
//		Thread t2 = new MyThread(s2);
		
		t1.start();
		t2.start();
	}
}

class MyThread extends Thread{
	private Student s;
	public MyThread() {
	}
	public MyThread(Student s) {
		this.s = s;
	}
	public void run() {
//		s.test();
//		s.test2();
		s.test3();
	}
}

/**   
֪ʶ��һ��
         ����̵߳���ͬһ�������еķ�����ʱ��,����������в�����һЩ��Ա����,��ô��ʱ��ͻ����һЩ���ݰ�ȫ������.
        ����ԭ��:java��ÿ��������һ�����������������е��Ǿ�̬��synchronizedͬ��������ʱ���Զ����������ִ�д�����ĵ�ǰʵ����thisʵ�����йص�����
 ���һ���������Ҳ��Ϊ��ȡ�������������ڶ������������ڶ�����ͬ����
* */
class Student{
	private int a;
	
	/**
	   	֪ʶ���������ĵڶ����÷���ͬ���Ǿ�̬��������Ϊʵ��������(this)
	 * */
	public synchronized void test(){
		String name =Thread.currentThread().getName();
		for(int i=0;i<10;i++){
			System.out.println("threadName="+name + ": a = " + a);
			a++;
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	      ֪ʶ���������ķ�����һ���÷���ͬ������飬��������ͬһʱ��ֻ��һ������飬������Ĭ����this 
	 * */
	public void test2(){
//		Object o = new Object();
		/*	
		 	�ֲ�����������һ�η�������һ���������������������������Ҫ�����߳�������ͬһ��������һ���������߳�ͬ��
		  
			��õ�ǰ���Class����(3�ַ���)��һ��������ֻ��һ��Class����֤�����ж�һ�޶��Ķ���
			�̲߳���ͬ��һ�����this�Ϳ��Ե�
		 * */
		synchronized (this){  
			String name =Thread.currentThread().getName();
			for (int i = 0; i < 10; i++) {
				System.out.println("threadName="+name + ": a = " + a);
				a++;
				try {
					if(a==5){
						this.wait(100);  //�ĸ�ָ���ȵ�����˭��
//						this.wait();    //����ʱ�����Ҫnotify()������
					}
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
//			this.notify();
//			this.notifyAll();
		}
	}
	/**
	       ֪ʶ���ģ�ͬ������������̬ͬ������ ����Ϊ�������(Student.class)
	                          һ��һ����̬ͬ��������ȡ���������ľ�̬ͬ������������ȴ��÷����ͷ�������ܻ�ȡ��
	 * */
	public static synchronized void test3(){
		String name = Thread.currentThread().getName();
		for(int i=0;i<10;i++){
			System.out.println("threadname+"+name+": i="+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	//test4�ȼ���test3
	public static int test4(){
	      synchronized(Student.class){
	      }
		return 0;
	}
}