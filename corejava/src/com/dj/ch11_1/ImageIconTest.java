package com.dj.ch11_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageIconTest {
	//����  (�൱��һ������)
	private JFrame frame;
	//��������  (�൱�������ϵ�����)
	private Container container;
	//Ƕ�׵����� �ŵ�container����
	private JPanel north;
	private JLabel lable1;
	private JButton but;
	
	public ImageIconTest() {
		//���ô��ڵı���
		frame = new JFrame("ImageIconTest");
		//��������еĸ�������
		container = frame.getContentPane();
		//����frame��λ��
		frame.setLocation(100, 100);
		//����frame�Ĵ�С
		frame.setSize(400, 400);
		//���õ���رպ��˳����java����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����init������ʼ��container�е����
		init();
		//����frame�ɼ�
		frame.setVisible(true);
	}
	private void init(){
		//��ʼ�������е����
		lable1 = new JLabel(new ImageIcon("src/com/dj/ch11_1/mouse.jpg"));
		but = new JButton();
		but.setIcon(new ImageIcon("src/com/dj/ch11_1/mouse.jpg"));
		north = new JPanel();
		container.add(north,BorderLayout.NORTH);
		container.add(but);
		north.setLayout(new FlowLayout());
		north.add(lable1);
	}
	
	public static void main(String[] args) {
		
		new ImageIconTest();
		
	}
}
