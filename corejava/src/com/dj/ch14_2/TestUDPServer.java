package com.dj.ch14_2;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPServer {
	public static void main(String args[]) throws Exception {
		//1.����һ��UDP��socket��������ʾ�Լ� ͬʱָ��һ���˿ں�
		DatagramSocket ds = new DatagramSocket(5678);
		
		//2.����һ���ֽ������Խ���UDP��
		byte buf[] = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		boolean flag = true;
		while (flag) {
			//3.����UDP�������ݣ� ������������߳�����
			ds.receive(dp);
			
			//4.���ݻ��Զ��Ľ��յ����ݰ�dp�����װ���ֽ�������buf
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			DataInputStream dis = new DataInputStream(bais);
			//�����ֽ������е�����
			System.out.println(dis.readLong());
		}
		//5.�ر����ݱ��׽���
		if(ds!=null)ds.close();
	}
}
