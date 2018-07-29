package com.dj.ch14;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//�����з������������пͻ���
public class TCPServer {

	public static void main(String[] args) {
		//�˿���1000~65000֮��ȡ
		int port = 9999;
		ServerSocket server = null;
		Socket socket = null;
		try {
			//1.����һ��ServerSocket�����ʾ��������ͬʱ��һ���˿�
			server = new ServerSocket(port);
			
			/*
			    2.����������������ͻ����������ӣ���������ӣ�����ͨ���׽���(socket����)��
			               ͨ�����socket�������֪���ͻ��˳������ڵĵ���IP�������ڴ�Ķ˿ںţ�֪��������ӵĿͻ�����˭�� 
			 * */
			System.out.println("�������˵ȴ��ͻ��˵�����...");
			socket = server.accept();
			System.out.println("�ͻ��˳������ڵĵ���IPΪ��"+socket.getInetAddress().getHostAddress());
			System.out.println("�ͻ��˳��������ڴ�Ķ˿ںţ�"+socket.getPort());
			System.out.println("�����������ӵ��˿ͻ���...");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//3.�ر�ͨ���׽���
				if(socket!=null)socket.close();
				if(server!=null)server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
