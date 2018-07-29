package com.dj.ch13_3;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedReaderAndWriterTest {
	
	public static void main(String[] args) {
		PipedWriter out = null;
		PipedReader in = null;
		try {
			out = new PipedWriter();
			in = new PipedReader(out);
			//����д�ַ����߳�
			Thread t1 = new MyThread1(out);
			//������ַ����߳�
			Thread t2 = new MyThread2(in);
			t1.start();
			t2.start();
			//˭����˭�ȴ�
			//main�̵߳��õ����jion����������main�̵߳ȴ�
			t1.join();
			t2.join();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			try {
				if(out!=null)out.close();
				if(in!=null)in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
class MyThread1 extends Thread{
	private PipedWriter out;
	public MyThread1(PipedWriter out) {
		this.out = out;
	}
	public void run() {
		char[] c = "hello".toCharArray();
		try {
			Thread.sleep(1000);
			out.write(c, 0, c.length);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class MyThread2 extends Thread{
	private PipedReader in;
	public MyThread2(PipedReader in) {
		this.in = in;
	}
	public void run() {
		char[] c = new char[50];
		try {
			Thread.sleep(3000);
			int len = in.read(c);
			System.out.println(new String(c,0,len));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
