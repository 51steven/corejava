package com.dj.ch14.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

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

public class ChatClient {
	private JFrame cliFrame;
	private JLabel ipLabel,portLabel,mesLabel,nickNmLabel;
	private JTextField ipText,portText,mesText,nickNmText;
	private JButton connButton,mesButton,nickNmButton;
	private JPanel northPanel,south1Panel,south2Panel,south3Panel;
	private JTextArea cliArea;
	private JScrollPane scroll;
	
	private BufferedReader br; 
	private PrintWriter pw; 
	private String nickNm; 
	
	public ChatClient() {
		nickNm = "���߳�����ͻ���";
		cliFrame = new JFrame();
		ipLabel = new JLabel("IP��", JLabel.LEFT);
		portLabel = new JLabel("�˿ڣ�", JLabel.LEFT);
		mesLabel = new JLabel("��Ϣ��", JLabel.LEFT);
		nickNmLabel = new JLabel("�ǳƣ�", JLabel.LEFT);
		
		ipText = new JTextField(10);
		portText = new JTextField(10);
		mesText = new JTextField(30);
		nickNmText = new JTextField(30);
		
		connButton = new JButton("����");
		mesButton = new JButton("ȷ��");
		nickNmButton = new JButton("ȷ��");
		
		northPanel = new JPanel();
		south1Panel = new JPanel();
		south2Panel = new JPanel();
		south3Panel = new JPanel();
		
		cliArea = new JTextArea();
		scroll = new JScrollPane(cliArea);
	}

	public void init(){
		//��������
		cliFrame.setTitle("���߳�����ͻ���");
		cliFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cliFrame.setSize(550, 550);
		
		//����
		northPanel.add(ipLabel);
		northPanel.add(ipText);
		northPanel.add(portLabel);
		northPanel.add(portText);
		northPanel.add(connButton);
		cliFrame.getContentPane().add(northPanel, BorderLayout.NORTH);

		//�м�
		cliArea.setFocusable(false);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		cliFrame.getContentPane().add(cliArea, BorderLayout.CENTER);
		
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
		cliFrame.getContentPane().add(south1Panel, BorderLayout.SOUTH);
		
		cliFrame.setVisible(true);
	}
	
	public void startUp(){
		init();
		//������Ϣ���߳�
		final Runnable receiveThread = new Runnable() {
			public void run() {
				String mes;
				try {
					while((mes=br.readLine())!=null){
						cliArea.append(mes+"\n");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		
		//����conn��ť�����ӷ�����
		connButton.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			public void actionPerformed(ActionEvent e) {
				String tip = ipText.getText();
				String tport = portText.getText();
				if(!"".equals(tip)&&!"".equals(tport)){
					try {
						Socket socket = new Socket(tip, Integer.parseInt(tport));
						br = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						pw = new PrintWriter(socket.getOutputStream());
						cliArea.append("������������...\n");
						//������Ϣ�߳�
						Thread t = new Thread(receiveThread);
						t.start();
					} catch (Exception  e1) {
						e1.printStackTrace();
						 JOptionPane.showMessageDialog(cliFrame, "���Ӳ��Ϸ�����!\n��ȷ�� IP�� �˿� ������ȷ��"); 
					}
				}else{
					JOptionPane.showMessageDialog(cliFrame, "��������ȷ��IP�Ͷ˿�");
				}				
			}
		});
		
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
					pw.println(nickNm+":"+tmes);
					pw.flush();
					mesText.setText("");
				}else{
					JOptionPane.showMessageDialog(cliFrame, "���ݲ���Ϊ�գ�"); 
				}
			}
		};
		mesButton.addActionListener(mesListener); 
		mesText.addActionListener(mesListener); 
	}
	
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		client.startUp();
	}
}
