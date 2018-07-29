package com.dj.ch11_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//��ʽ���ֹ�����
public class FlowLayoutTest {
	
	private JFrame frame;
	private Container container;
	
	//����һ��JButton���͵�����
	private JButton[] buts;
	//����һ���μ�����panel������Ƕ�׵���
	private JPanel panel;
	
	public FlowLayoutTest(){
		
		frame = new JFrame("FlowLayout");
		container = frame.getContentPane();
		frame.setLocation(100, 100);
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		frame.setVisible(true);
		
	}
		private void init(){
			//��ʼ��panel
			panel = new JPanel();
			
			//����container�Ĳ��ֹ�����ΪBorderLayout
			container.setLayout(new BorderLayout());
			
			container.add(panel);
			
			//��panel����һ�����ֹ�����FlowLayout
			//��ʵpanelĬ�ϵĲ��ֹ�����Ҳ��FlowLayout
			panel.setLayout(new FlowLayout());
			
			buts = new JButton[50];
			//ѭ������50����ť���ҷ���panel��
			for(int i=1;i<=buts.length;i++){
				if(i<10){
					buts[i-1] = new JButton("0"+i);  //�淶��ʾ
				}else if(i<=50){
					buts[i-1] = new JButton(""+i);
				}
				panel.add(buts[i-1]);  //�Ѱ�ť�ŵ�������
			}
			
		}
		public static void main(String[] args) {
			new FlowLayoutTest();
		}
	
	
}
