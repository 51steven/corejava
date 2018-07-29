package com.dj.ch13_1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//�����ģʽ�����
public class InputAndOutputStream {
	public static void main(String[] args) {
		InputStream in = System.in;
		OutputStream out = System.out;
		try {		
			byte[] b = new byte[512];
			int len = -1;
			while((len=in.read(b))!=-1){
				out.write(b, 0, len);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
	    }finally{
	    	try {
	    		//�ر����Ļ���ԭ���ȹر����������ڹر������
				  if(in!=null)in.close();
				  if(out!=null)out.close();
			} catch (IOException e) {
				  e.printStackTrace();
			}
		 }
	}
}
