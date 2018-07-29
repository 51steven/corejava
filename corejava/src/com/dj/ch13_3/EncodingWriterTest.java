package com.dj.ch13_3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class EncodingWriterTest {
	public static void main(String[] args) {
		//1.Ĭ�ϱ��룬���ַ�ʽ���,����Ҫʹ��Ĭ�ϵı���ȥ���ж�д�ַ�
		/*PrintWriter out = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter("src/com/dj/ch13_3/c.txt");
			out = new PrintWriter(fw);
			System.out.println(fw.getEncoding());
			out.println("���");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw!=null)fw.close();
				if(out!=null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		//2.���ñ���
		OutputStream os = null;
		OutputStreamWriter osw = null;
		PrintWriter out = null;
		try {
			os = new FileOutputStream("src/com/dj/ch13_3/c.txt");
//			osw = new OutputStreamWriter(os, "utf8");
			osw = new OutputStreamWriter(os, "GBK");
			out = new PrintWriter(osw);
			out.println("��ã����");
			out.println("hello,world");
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}finally {
			try {
				if(os!=null)os.close();
				if(osw!=null)osw.close();
				if(out!=null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}  
	}
}
