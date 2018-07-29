package com.dj.ch11_1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MyFirstGUI {
	//��������
	private JFrame frame;
	//�μ�����
	private Container container;
	//��ť
	private JButton button;
	//Lable��ǩ,��д���
	private JLabel addLablel,eqsLabel;
	//�ı������
	private JTextField f1,f2,f3;
	
	
	public MyFirstGUI(){
		//��ʼ������(�൱������)
		frame = new JFrame();
		//��ôμ���������(�൱������)
		container = frame.getContentPane();
		//����1��2������frame��λ�ã�������Ļ���Ͻ�Ϊ(0,0)����
		//����3��4��frame��ʾ�Ĵ�С(����)
		frame.setBounds(40,40, 400, 400);
		//����������ϽǺ����Թرճ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�൱�����ý���ı����ڽ�����ϱ߽�����
		frame.setTitle("this id my first GUI");
		init();
		//���ý��������ʾ��Ĭ��������ʼ�����֮�������ص�
		frame.setVisible(true);
		
	}
	
		//��ʼ�����
		private void init(){
			
			button = new JButton("add");
			addLablel = new JLabel("+");
			eqsLabel = new JLabel("=");
			//�����ı��������󣬲����ó���Ϊ5
			f1 = new JTextField(5);
			f2 = new JTextField(5);
			f3 = new JTextField(5);
			
			//���������Ĳ��ֹ�����
			container.setLayout(new FlowLayout());
			
			container.add(f1);
			container.add(addLablel);
			container.add(f2);
			container.add(eqsLabel);
			container.add(f3);
			container.add(button);
			
			//��ָ�����������¼�����,�����ڲ���
			button.addActionListener(new ActionListener() {
				//����������ָ����ť��ʱ�򣬳���ͻ�����������
				@Override
				public void actionPerformed(ActionEvent e) {
					//�õ���һ��������е�����(Stringת��ΪDouble)
					double a = Double.parseDouble(f1.getText());
					
					//�õ��ڶ���������е�����(String ת��ΪDouble)
					double b = Double.parseDouble(f2.getText());
					
					//��ӵõ����,���ŵ��������������
					double c = a+b;
					f3.setText(c+""); //ת���ַ�����
				}
			});
			
		}
	
	public static void main(String[] args) {
		
		new MyFirstGUI();
	}
}
