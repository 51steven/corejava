package com.dj.ch14;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient3 {
	
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 9999;
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		try {
			/*
			   1.����һ���׽��֣������ӵ���������
			        ���ӵ�IP��127.0.0.1
			         ������socket�����ܴ���������˵���ͻ��˺ͷ������Ѿ�����
			 * */
			 socket = new Socket(ip, port);
			 System.out.println("�ͻ����Ѿ��ɹ������ӵ��˷�����...");
			
			 /*
			     getOutputStream()��getInputStream()��ȡ�����������������ʼ�������ݵķ��ͺͽ��� 
			  * */
		     in = socket.getInputStream();
		     byte[] buf = new byte[1024];
		     int len=  in.read(buf);
			 System.out.write(buf, 0, len);
			 System.out.flush();
			 
			 out = socket.getOutputStream();
			 out.write("world".getBytes());
			 out.flush();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//3.�ر�ͨ���׽���
				if(in!=null)in.close();
				if(out!=null)out.close();
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
