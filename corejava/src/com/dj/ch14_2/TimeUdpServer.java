package com.dj.ch14_2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

//����ˣ����ա�����
public class TimeUdpServer{
	public static void main(String[] args){
		//��ǰ�׽���ʹ�õĶ˿�
		int port = 9999;
		//UDP�׽���(Socket)
		DatagramSocket ds = null;
		//���ݱ���
		DatagramPacket dp = null;
		//�����������ݵ�����
		byte[] buf = new byte[1024];
		//���յ����ݰ����Ǹ��ͻ��˵�IP��ַ
		InetAddress clientAddress = null;
		//���յ����ݰ����Ǹ��ͻ�����ʹ�õĶ˿�
		int clientPort;
		String time = new Date().toString();
		try{
			//1.����һ���������ͺͽ������ݱ������׽��֣���ָ��ʹ�õĶ˿�
			//����һ��UDP��socket �������պͷ�������
			ds = new DatagramSocket(port);
			//2.����һ�����ݱ�������
			dp = new DatagramPacket(buf,buf.length);
			while(true){
				//3.�������ݰ� (û�н��ܵ��ͻ��߳�����)
				ds.receive(dp);
				//4.���յ����ݰ�������������������ip�Ͷ˿�
				clientAddress = dp.getAddress();
				clientPort = dp.getPort();
				System.out.println("clientAddress = "+clientAddress);
				System.out.println("clientPort = "+clientPort);
				
				//5.׼���ø����͵�����
				buf = time.getBytes();
				//�����ݷ�װ�����ݰ��У�ָ������������IP�Ͷ˿�
				dp = new DatagramPacket(buf,buf.length,clientAddress,clientPort);
				//6.����
				ds.send(dp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(ds != null)ds.close();
			}catch(Exception e){}
		}
	}
}

