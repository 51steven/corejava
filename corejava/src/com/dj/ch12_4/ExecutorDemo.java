package com.dj.ch12_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * �̳߳�
 * */
public class ExecutorDemo {
	public static void main(String[] args) {
		//����һ������߳���Ϊ3���̳߳�ִ����,������������˳��ִ�У���Ϊ�̳߳���ֻ��һ���߳�
//		ExecutorService executor = Executors.newFixedThreadPool(3);
		//Ϊÿ���ȴ������񴴽�һ�����̣߳����ԣ��������񶼲���ִ��
		ExecutorService executor = Executors.newCachedThreadPool();
//		Executors.newCachedThreadPool()--ExExecutorService-->Executor
		
		executor.execute(new PrintChar('a',5));
		try {
			Thread.sleep(100);
			System.out.println();
			System.out.println("...............................");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.execute(new PrintChar('b',5));
		try {
			Thread.sleep(100);
			System.out.println();
			System.out.println("...............................");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executor.execute(new PrintNum(5));
		//ִ֪ͨ�����رգ����ٽ��������񣬵����߳������е�δ��ɵ����񽫼���ִ��ֱ�����
		executor.shutdown();
	}
}
class PrintChar implements Runnable{
	private char charToPrint;
	private int times;
	public PrintChar() {
	}
	public PrintChar(char c, int t) {
		this.charToPrint = c;
		this.times = t;
	}
	public void run() {
		for(int i=0;i<times;i++){
			System.out.print("PrintChar��"+charToPrint+"��"+i+"\t");
		}
	}
}
class PrintNum implements Runnable{
	private int lastNum;
	public PrintNum() {
	}
	public PrintNum(int n) {
		this.lastNum = n;
	}
	public void run() {
		for(int i=1;i<=lastNum;i++){
			System.out.print("PrintNum��"+i+"\t");
		}
	}
}

