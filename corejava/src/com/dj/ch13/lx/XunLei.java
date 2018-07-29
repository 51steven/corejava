package com.dj.ch13.lx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class XunLei {
	public static void main(String[] args) {
		RandomAccessFile in = null;
		RandomAccessFile out = null;
		try {
			File file = new File("src/com/dj/ch13/lx/a.txt");
			long length = file.length();
			in = new RandomAccessFile(file, "r");
			out = new RandomAccessFile("src/com/dj/ch13/lx/d.txt", "rw");
			Thread t1 = new MyThread(in, out, 0, length/3);
			Thread t2 = new MyThread(in, out, length/3, length*2/3);
			Thread t3 = new MyThread(in, out, length*2/3, length);
			t1.start();
			t2.start();
			t3.start();
			t1.join();
			t2.join();
			t3.join();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class MyThread extends Thread{
	private RandomAccessFile in;
	private RandomAccessFile out;
	private long start;
	private long end;
	public MyThread(RandomAccessFile in,RandomAccessFile out, long start, long end) {
		this.in = in;
		this.out = out;
		this.start = start;
		this.end = end;
	}
	public void run() {
		byte[] buf = new byte[1024];
		String name = Thread.currentThread().getName();
		while(start<end){
			synchronized (this.getClass()) {
			try {
				in.seek(start);
				out.seek(start);
				int len = in.read(buf);
				if((start+len)>end){
					len = (int) (end-start);
				}
				System.out.println(name+"д��b.txt"+len+"���ֽ�");
				out.write(buf, 0, len);
				start+=len;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	   }
	}
}
