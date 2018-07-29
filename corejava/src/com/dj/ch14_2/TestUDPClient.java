package com.dj.ch14_2;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TestUDPClient {
	public static void main(String args[]) throws Exception {
		long n = 123L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);
		//1.����һ��UDP��socket��������ʾ�Լ� ͬʱָ��һ���˿ں�
		DatagramSocket ds = new DatagramSocket(9999);
		
		//2.��Ҫ���͵��ֽ������е����ݷ�װ�����ݰ���(DatagramPacket),ͬʱָ�����͵�Ŀ���ip�Ͷ˿ں�
		//׼����һ��Ҫ���͵��ֽ�����
		byte[] buf = baos.toByteArray();
		DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 5678));
		
		//3.��������ݰ����Լ��󶨵Ķ˿ںų�����,������Ŀ���ַ
		ds.send(dp);
		
		//4.�ر����ݱ��׽���
		ds.close();
	}
}
