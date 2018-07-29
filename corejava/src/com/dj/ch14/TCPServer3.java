package com.dj.ch14;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer3 {

	public static void main(String[] args) {
		
		int port = 9999;
		ServerSocket server = null;
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		try {
			//1.����һ��ServerSocket�����ʾ��������ͬʱ��һ���˿�
			server = new ServerSocket(port);
			
			/*
			    2.����������������ͻ����������ӣ���������ӣ�����ͨ���׽���(socket����)��
			               ͨ�����socket�������֪���ͻ��˳������ڵĵ���IP�������ڴ�Ķ˿ںţ�֪��������ӵĿͻ�����˭�� 
			 * */
			System.out.println("�������˵ȴ��ͻ��˵�����...");
			socket = server.accept();
			System.out.println("�����������ӵ��˿ͻ���...");
			
			/*
			     3.getOutputStream()��getInputStream()��ȡ�����������������ʼ�������ݵķ��ͺͽ��� 
			 * */
		    out = socket.getOutputStream();  
			byte[] buf = "hello".getBytes();
			out.write(buf, 0, buf.length);
			out.flush();
			
			in = socket.getInputStream();
			buf = new byte[1024];
			int len = in.read(buf);
			System.out.write(buf, 0, len);
			System.out.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//4.�ر�ͨ���׽���
				if(out!=null)out.close();
				if(in!=null)in.close();
				if(server!=null)server.close();
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
