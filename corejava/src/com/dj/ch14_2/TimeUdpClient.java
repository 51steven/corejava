package com.dj.ch14_2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

//�ͻ��ˣ����͡�����
public class TimeUdpClient{
	public static void main(String[] args){
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		byte[] buf = new byte[1024];
		InetAddress serverAddress = null;
		int serverPort = 9999;
		String serverIp = "127.0.0.1";
		try{
			//1.�������ݱ��׽���,�Լ��Զ���һ��ϵͳ�п��õĶ˿�,����Ҳ���Ը���ָ��һ���˿�
			ds = new DatagramSocket();
			//2.Ҫ�����ݷ��͵��Ǹ�������IP
			serverAddress = InetAddress.getByName(serverIp);
			//�����ݷ�װ�����ݰ��У�ָ������������IP�Ͷ˿�
			//ֻ��������Ĵ�����ݵ�������û���κ�����
			dp = new DatagramPacket(buf,buf.length,serverAddress,serverPort);
			//3.�������ݰ�
			ds.send(dp);
			
			//4.����һ�����ݰ�����,������������
			dp = new DatagramPacket(buf,buf.length);
			//5.�������ݰ� (�̻߳�����)
			ds.receive(dp);
			System.out.println("Time:" + new String(buf));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				//6.
				if(ds != null)
					ds.close();
			}catch(Exception e){}
		}
	}
}
