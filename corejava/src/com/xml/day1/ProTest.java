package com.xml.day1;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

public class ProTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		//���������о����䶯���Ժ���ܻ�䶯����Ϣ�����������ļ�
		
		int port = 0;
		
		Properties prop = new Properties();
		
		prop.load(new FileInputStream("src/com/xml/day1/test.properties"));
		
		port = Integer.parseInt(prop.getProperty("port"));
		
		System.out.println("�˿ں�Ϊ��"+port);
		
		@SuppressWarnings("resource")
		ServerSocket socket = new ServerSocket(port);
		
	}
}
