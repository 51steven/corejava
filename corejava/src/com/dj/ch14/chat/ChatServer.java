package com.dj.ch14.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * ���߳���������
 * */
public class ChatServer {
	private JFrame serFrame;
	private JLabel portLabel,mesLabel,nickNmLabel;
	private JTextField portText,mesText,nickNmText;
	private JButton startButton,mesButton,nickNmButton;
	private JPanel northPanel,south1Panel,south2Panel,south3Panel;
	private JTextArea serArea;
	private JScrollPane scroll;
	
	private String nickNm;
	private ArrayList<PrintWriter> serverOutputStream;
	private int portInt;

	//1�����ڻ������Գ�ʼ��
	public ChatServer() {
		nickNm = "���߳���������";
		serFrame = new JFrame();
		portLabel = new JLabel("�˿�", JLabel.LEFT);
		mesLabel = new JLabel("��Ϣ", JLabel.LEFT);
		nickNmLabel = new JLabel("�ǳ�", JLabel.LEFT);
		
		portText = new JTextField(30);
		mesText = new JTextField(30);
		nickNmText = new JTextField(30);
		
		startButton = new JButton("��ʼ");
		mesButton = new JButton("ȷ��");
		nickNmButton = new JButton("ȷ��");
		
		northPanel = new JPanel();
		south1Panel = new JPanel();
		south2Panel = new JPanel();
		south3Panel = new JPanel();
		
		serArea = new JTextArea();
		scroll = new JScrollPane(serArea);
	}

	//2�� �������
	public void init(){
		//��������
		serFrame.setTitle("���߳���������");
		serFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serFrame.setSize(550, 550);
		
		//����
		northPanel.add(portLabel);
		northPanel.add(portText);
		northPanel.add(startButton);
		serFrame.getContentPane().add(northPanel, BorderLayout.NORTH);

		//�м�
		serArea.setFocusable(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		serFrame.getContentPane().add(serArea, BorderLayout.CENTER);
		
		//����
		south2Panel.add(nickNmLabel);
		south2Panel.add(nickNmText);
		south2Panel.add(nickNmButton);
		south3Panel.add(mesLabel);
		south3Panel.add(mesText);
		south3Panel.add(mesButton);
		south1Panel.setLayout(new BoxLayout(south1Panel, BoxLayout.Y_AXIS));
		south1Panel.add(south2Panel);
		south1Panel.add(south3Panel);
		serFrame.getContentPane().add(south1Panel, BorderLayout.SOUTH);
		
		serFrame.setVisible(true);
	}
	
	public void startUp(){
		init();
		//������ʼ��ť
		ActionListener startListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverOutputStream = new ArrayList<PrintWriter>();
				final String tport = portText.getText();
				if(!"".equals(tport)){
					/*portInt = Integer.parseInt(tport);
					//������Ϣ�߳�
					Runnable threadServer = new ThreadServer(portInt, serArea);
					Thread server = new Thread(threadServer);
					server.start();*/
					
					Runnable serverThread = new Runnable() {
						public void run() {
							ServerSocket server = null;
							try {
								//1.����һ��ServerSocket�����ʾ��������ͬʱ��һ���˿�
								server = new ServerSocket(Integer.parseInt(tport));
								while(true){
									serArea.append("�ȴ��ͻ�������...\n");
									//2.������������
									Socket accept = server.accept();
									serArea.append("�ͻ���������...\n");
									//3.��ȡ�����������������ʼ�������ݵķ��ͺͽ���
									 PrintWriter pw = new PrintWriter(accept.getOutputStream());
									 serverOutputStream.add(pw);
									 Thread client = new Thread(new ThreadClient(accept, serverOutputStream, serArea));
									 client.start();
								}
							} catch (NumberFormatException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					};
					Thread server = new Thread(serverThread);
					server.start();
				}else{
					JOptionPane.showConfirmDialog(serFrame, "�˿ںŲ���Ϊ�գ���������ȷ�˿ں�...");
				}
			}
		};
		startButton.addActionListener(startListener);
		portText.addActionListener(startListener);
		
		//�����ǳ�
		ActionListener nickNmListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tnickNm = nickNmText.getText();
				if(!"".equals(tnickNm))
					nickNm = tnickNm;
			}
		};
		nickNmButton.addActionListener(nickNmListener);
		nickNmText.addActionListener(nickNmListener);
		nickNmText.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				String tnickNm = nickNmText.getText();
				if(!"".equals(tnickNm))
					nickNm = tnickNm;
			}
			public void focusGained(FocusEvent e) {}
		});
		
		//����mes��ť��������Ϣ
		ActionListener mesListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tmes = mesText.getText();
				if(!"".equals(tmes)){
					tmes = nickNm+":"+tmes;
//					new ThreadServer(portInt, serArea).sendMesToClient(tmes);
					sendMesToClient(tmes);
					serArea.append(tmes+"\n");
					mesText.setText("");
				}else{
					JOptionPane.showMessageDialog(serFrame, "���ݲ���Ϊ�գ�"); 
				}
			}
		};
		mesButton.addActionListener(mesListener); 
		mesText.addActionListener(mesListener); 
	}

	private void sendMesToClient(String mes){
		Iterator<PrintWriter> it = serverOutputStream.iterator();
		while(it.hasNext()){
			PrintWriter pw = it.next();
			pw.println(mes);
			pw.flush();
		}
	}
	public static void main(String[] args) {
		ChatServer cs = new ChatServer();
		cs.startUp();
	}
}


