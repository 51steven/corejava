package com.dj.ch11_1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleFrame {
	public static void main(String[] args) {
		//����һ������
		Frame f = new Frame("hello");
		
		//���������һ������رյ��¼�(���ǵ���رյ�ʱ��ִ��ʲô����ȥ��ʲô����)
		//�������ӵĻ�,��ô���ھ��޷����ر�,ֻ����ϵͳ������ɱ���������(kill����)
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//�����������һ����ť
		f.add(new Button("Press Me"));
		//���������Ĵ�С
		f.setSize(100,100);
		//������������ɼ�
		f.setVisible(true);
	}
}
