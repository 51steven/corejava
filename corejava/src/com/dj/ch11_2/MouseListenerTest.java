package com.dj.ch11_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerTest extends JFrame{
	private JLabel northLbl;
	private JLabel centerLbl;
	public MouseListenerTest(String title){
		setTitle(title);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}
	private void init(){
		northLbl = new JLabel("status:");	
		centerLbl = new JLabel("");
		centerLbl.setBackground(Color.YELLOW);
		//���ò���ʾ��ǩ�����������ɫ(�����Ϳ�����ʾ�Լ�����ɫ��)
		centerLbl.setOpaque(true);
		add(northLbl,BorderLayout.NORTH);
		add(centerLbl,BorderLayout.CENTER);
		process();
	}
	//ר�Ÿ��������¼������ķ���
	private void process(){
		//��centerLbl ���ָ������������������մ��������������¼���
		centerLbl.addMouseListener(new MouseListener(){
			//��갴��������ϵ��������²��ͷţ�ʱ���á� 
			public void mouseClicked(MouseEvent e){}	
			//�����뵽�����ʱ���á�
			public void mouseEntered(MouseEvent e){}
			//����뿪���ʱ���á�
			public void mouseExited(MouseEvent e){}
			//��갴��������ϰ���ʱ����
			public void mousePressed(MouseEvent e){
				String info = "status:press,x=" + e.getX() + ",y=" + e.getY();
				northLbl.setText(info);
			}
			//��갴ť��������ͷ�ʱ���á�
			public void mouseReleased(MouseEvent e){}
		});
		
		//��centerLbl ���ָ��������ƶ������������մ��������������ƶ��¼���
		centerLbl.addMouseMotionListener(new MouseMotionAdapter(){
			//e��ʾ����ƶ�����¼�����
			public void mouseMoved(MouseEvent e){
				//e.getX() e.getY() ͨ���¼���������굱ǰ������
				String info = "status:move,x=" + e.getX() + ",y=" + e.getY();
				//���ַ������õ�northLbl��
				northLbl.setText(info);
			}
			
		});
	}
	public static void main(String[] args){
		MouseListenerTest mlt = new MouseListenerTest("MultiListener Test");
	}
}
