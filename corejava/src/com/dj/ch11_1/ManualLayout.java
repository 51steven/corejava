package com.dj.ch11_1;

import java.awt.Button;
import java.awt.Frame;

public class ManualLayout {
	public static void main(String[] args) {
		//����һ����������
		Frame f = new Frame("this id my first frame");
		//ȡ�����ֹ����� ��FrameĬ����BorderLayout
		f.setLayout(null);
		//����
		f.setSize(400,400);
		//����һ����ť����
		Button b = new Button("press me");
		b.setSize(80,30);
		//���ð�ť�������е�λ�ã�������Ͻǣ�0,0��������
		b.setLocation(40,60);
		//�Ѱ�ť�ŵ�������
		f.add(b);
		//���������ɼ�
		f.setVisible(true);
		
		
		
		
		
		
		
	}
}
