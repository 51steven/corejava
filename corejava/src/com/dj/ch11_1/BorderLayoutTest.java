package com.dj.ch11_1;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

//�߽粼�ֹ�����
public class BorderLayoutTest {
	//��������
	private JFrame frame;
	//��������
	private Container container;
	
	private JButton north,south,west,east,center;
	
	public BorderLayoutTest(){
		//���ô��ڵı���
		frame = new JFrame("BorderLayout");
		//��������еĸ�������
		container = frame.getContentPane();
		//����frame��λ��
		frame.setLocation(100,100);
		//����frame�Ĵ�С
		frame.setSize(400, 400);
		//���õ���رպ��˳��������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����init������ʼ��container�е����
		init();
		frame.setVisible(true);
		
	}
		private void init(){
			//��ʼ�������ť
			north = new JButton("north");
			south = new JButton("south");
			west = new JButton("west");
			east = new JButton("east");
			center = new JButton("center");
			
			//����container�Ĳ��ֹ�����ΪBorderLayout
			//��ʵĬ�ϲ��ֹ�����Ҳ�����
			container.setLayout(new BorderLayout());
			
			//�Ѱ�ť��ӵ�container�У���ָ����ӵ���λ��
			container.add(north,BorderLayout.NORTH);
			container.add(south,BorderLayout.SOUTH);
			container.add(west,BorderLayout.WEST);
			container.add(east,BorderLayout.EAST);
			
			//container.add(center)����д�������Ч����һ����
			//����㲻ָ���ŵ�BorderLayout�Ǹ�λ�õ�ʱ��
			//����Ĭ�ϵİ�����ŵ��м��Ǹ�λ��
			container.add(center,BorderLayout.CENTER);
			
		}
		public static void main(String[] args) {
			new BorderLayoutTest();
		}
}
