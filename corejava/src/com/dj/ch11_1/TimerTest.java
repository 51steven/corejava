package com.dj.ch11_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TimerTest {
	//����  (�൱��һ������)
	private JFrame frame;
	//��������  (�൱�������ϵ�����)
	private Container container;
	//Ƕ�׵����� �ŵ�container����
	private JPanel north;
	private JLabel lable1;
	private Timer timer;
	
	public TimerTest() {
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
		//��ʼ�������е����
		lable1 = new JLabel("10");
		
		timer = new Timer(1000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//�õ���ǩ�е�ֵ
				String text = lable1.getText();
				//ת��Ϊ����
				int x = Integer.parseInt(text);
				//�Ȱ����ּ�1Ȼ�������õ���ǩ����ʾ
				lable1.setText(--x+"");
				//�����ǩ�е�ֵΪ��0 ��رն�ʱ��
				if(x==0){
					timer.stop();
				}
			}
		});
		north = new JPanel();
		//���������Ĳ��ֹ��������������ӵ���Ӧ��λ��
		container.add(north,BorderLayout.NORTH);
		north.setLayout(new FlowLayout());
		north.add(lable1);
		
		//������ʱ��
		timer.start();
	}
	
	public static void main(String[] args) {
		
		new TimerTest();
		
	}
}
