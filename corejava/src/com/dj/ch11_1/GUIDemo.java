package com.dj.ch11_1;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GUIDemo {
	//������  (�൱��һ������)
	private JFrame frame;
	//��������  (�൱�������ϵ�����)
	private Container container;
	//Ƕ�׵����� 
	private JPanel panel;
	//��������Ҫ�õ��ĸ������
	private JLabel lable1;
	private JButton but;
	private Timer timer;	//ʱ����
	
	public GUIDemo() {
		//������д��ڵĳ�����������
		//���ô��ڵı���
		frame = new JFrame("TimerTest");
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
		//������ŵ������еĸ���������г�ʼ��
		//....
		
		//������������Ƕ������Ĳ��ֹ�����
		//....
		
		//�Ѹ��������ӵ���Ӧ�����е�ָ��λ��
		//....
		
		//����������Ҫ�¼����������¼��������� 
		//�����û��ڽ����е�������������ѡ��������ж�Ӧ�Ĵ��봦������
		//...
	}
	
	public static void main(String[] args) {
		
		new GUIDemo();
		
	}
}
