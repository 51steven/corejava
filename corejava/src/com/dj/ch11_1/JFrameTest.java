package com.dj.ch11_1;

import java.awt.Color;

import javax.swing.JFrame;

public class JFrameTest{
	public static void main(String[] args){
		
		JFrame frame = new JFrame();
		frame.setTitle("First GUI program");
		//����frame�Ĵ�С
		frame.setSize(500,500);
		//����frame��λ��
		frame.setLocation(100,100);
		//����frame��С���ɱ仯
		frame.setResizable(false);
		//���ñ�����ɫ
		frame.getContentPane().setBackground(Color.YELLOW);
		//���õ���˳��¼�
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����frame�ɼ�
		frame.setVisible(true);
	}
}
