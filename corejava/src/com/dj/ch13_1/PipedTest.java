package com.dj.ch13_1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedTest {
	
	public static void main(String[] args) {
		try {
			PipedInputStream in = new PipedInputStream();
			PipedOutputStream out = new PipedOutputStream(in);  //���������ܵ��Ľӿ�(in),ֻ���������ܵ����е�����һ�����Ӽ���
		
			//���������߳�
			Thread t1 = new MyThread1(out);
			//���������߳�
			Thread t2 = new MyThread2(in);
			
			t1.start();
			t2.start();
		} catch (Exception e) {
		}
	}
}

//�����ͣ���ܵ��з�������
class MyThread1 extends Thread{
	private PipedOutputStream out;
	public MyThread1(PipedOutputStream out) {
		this.out = out;
	}
	public void run() {
		try {
			String str = "hello world";
			byte[] bytes = str.getBytes();
			for (byte b : bytes) {
				out.write(b);
				out.flush();
				Thread.sleep(1000);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (out != null)out.close();
			} catch (Exception e2) {
			}
		}
	}
}

//������գ��ӹܵ��н�������
class MyThread2 extends Thread{
	private PipedInputStream in;
	public MyThread2(PipedInputStream in) {
		this.in = in;
	}
	public void run() {
		OutputStream out = System.out;
		try {
			int len = -1;
			while((len=in.read())!=-1){
				out.write(len);
				out.flush();
			}
			System.out.println();
			System.out.println("len="+len);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (in != null)in.close();
			} catch (Exception e2) {
			}
		}
	}
}