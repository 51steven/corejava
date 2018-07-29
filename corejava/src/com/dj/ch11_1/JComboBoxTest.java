package com.dj.ch11_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JComboBoxTest {
	
	//����  (�൱��һ������)
	private JFrame frame;
	//��������  (�൱�������ϵ�����)
	private Container container;
	//Ƕ�׵����� �ŵ�container����
	private JPanel north;
	//�����б�
	private JComboBox<String> box;
	
	public JComboBoxTest() {
		//���ô��ڵı���
		frame = new JFrame("JComboBoxTest");
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
		box = new JComboBox<String>();
		//���box��ѡ��...
		box.addItem("�˵�");
		box.addItem("��ѯ");
		box.addItem("ע��");
		box.addItem("��¼");
		
		north = new JPanel();
		container.add(north,BorderLayout.NORTH);
		north.setLayout(new FlowLayout());
		north.add(box);
	}
	
	public static void main(String[] args) {
		
		new JComboBoxTest();
		
	}
}
