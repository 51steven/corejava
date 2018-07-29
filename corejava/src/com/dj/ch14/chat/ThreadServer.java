package com.dj.ch14.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextArea;

/**
 * �̷߳����
 * */
public class ThreadServer implements Runnable{
	/**����������*/
	public static ArrayList<PrintWriter> serverOutputStream = null; 
	/**����˶˿�*/
	int port;
	/**����˻Ự����*/
	JTextArea serArea;
	
	public ThreadServer() {}
	
	public ThreadServer(int port,JTextArea serArea) {
		this.port = port;
		this.serArea = serArea;
		serverOutputStream = new ArrayList<PrintWriter>(); 
	}

	public void run() {
		ServerSocket server = null;
		Socket socket = null;
		try {
			//1.����һ��ServerSocket�����ʾ��������ͬʱ��һ���˿�
			server = new ServerSocket(port);
			while(true){
				serArea.append("�ȴ��ͻ�������...\n");
				//2.������������
				socket = server.accept();
				serArea.append("�ͻ���������...\n");
				//3.��ȡ�ͻ������������ʼ�������ݵķ��ͺͽ���
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				serverOutputStream.add(pw);
				Thread client = new Thread(new ThreadClient(socket, serverOutputStream, serArea));
				client.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**������Ϣ���ͻ���*/
	public void sendMesToClient(String mes){
		Iterator<PrintWriter> it = serverOutputStream.iterator();
		boolean hasNext = it.hasNext();
		while(it.hasNext()){
			PrintWriter pw = it.next();
			pw.println(mes);
			
			pw.flush();
		}
	}

}
