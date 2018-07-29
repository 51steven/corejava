package com.dj.ch14;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		int port = 9999;
		Socket socket = null;
		try {
			/*
			        ����һ����������
			        ���ӵ�IP��127.0.0.1
			         ������socket�����ܴ���������˵���ͻ��˺ͷ������Ѿ�����
			 * */
			socket = new Socket(ip, port);
			System.out.println("�ͻ����Ѿ��ɹ������ӵ��˷�����");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(socket!=null)socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
