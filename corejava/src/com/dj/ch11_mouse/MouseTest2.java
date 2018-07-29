package com.dj.ch11_mouse;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MouseTest2 extends JFrame implements ActionListener{
	//����һЩ����Ҫ�õĶ���
	private Container container;
	private JPanel north,center;
	private JComboBox<String> box;
	private JLabel timeLabel,time,centLabel,cent;
	private JButton start;
	
	private JButton[] btns;
	
	private Timer timer;
	private ImageIcon icon;
	private Timer mouseTimer;
	private int level;
	
	private boolean flag;
	//��һ���������λ��
	private int lastMouse = -1;
	
	 public MouseTest2() {
		 //���ô��ڵĻ�������
		setTitle("�����������Ϸ");
		container = getContentPane();
		setLocation(100, 100);
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		init();
		setVisible(true);
	
	}
	 
	private void init(){
		//��ʼ�����
		north = new JPanel();
		center = new JPanel();
		box = new JComboBox<String>();
		box.addItem("����");
		box.addItem("�м�");
		box.addItem("�߼�");
		
		timeLabel = new JLabel("time:");
		time = new JLabel("10");
		centLabel = new JLabel("cent:");
		cent = new JLabel("0");
	    start = new JButton("��ʼ");
		
		btns  = new JButton[9];
		for(int i=0;i<btns.length;i++){
			btns[i] = new JButton();
			btns[i].setEnabled(false);//1
		}
		
		icon = new ImageIcon("src/com/dj/ch11_3/mouse.jpg");
		
		//���������Ĳ��ֹ�����
		north.setLayout(new FlowLayout());
		center.setLayout(new GridLayout(3, 3));
		container.setLayout(new BorderLayout());
		
		//�������ӵ�������
		north.add(box);
		north.add(timeLabel);
		north.add(time);
		north.add(centLabel);
		north.add(cent);
		north.add(start);
		
		for(int i=0;i<btns.length;i++){
			center.add(btns[i]);
		}
		
		container.add(north, BorderLayout.NORTH);
		container.add(center, BorderLayout.CENTER);
		
		
		
		//����¼�����
		start.addActionListener(this);
		
		timer = new Timer(1000, this);
		level = 1000;
		mouseTimer = new Timer(level, this);
		box.addActionListener(this);
		for(int i=0;i<btns.length;i++){
			btns[i].addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//ͨ���¼��������¼�Դ
		Object source = e.getSource();
		//start��ť�����¼�
		if(start == source){
			//1.1.��ť����Ϊ���õ�
			for(int i=0;i<btns.length;i++){
				btns[i].setEnabled(true);
			}
			box.setEnabled(false);//���𲻿ɶ�
			start.setEnabled(false);//��ʼ���ɰ�
			cent.setText("0");
			time.setText("10");
			timer.start();
			mouseTimer.start();
		}
		//����ʱ�����¼�
		else if(timer ==source){
			String text = time.getText();
			int num = Integer.parseInt(text);
			if(num<=0){
				
				timer.stop();
				mouseTimer.stop();
				if(lastMouse!=-1){
					btns[lastMouse].setIcon(null);
				}
				box.setEnabled(true);
				start.setEnabled(true);	
				for(int i=0;i<btns.length;i++){
					btns[i].setEnabled(false);
				}
			}else{
				num--;
				time.setText(num+"");
			}
		}
		//����ʱ�������¼�
		else if(mouseTimer == source){
			if(lastMouse!=-1){
				btns[lastMouse].setIcon(null);
			}
			int x = (int)(Math.random()*9);  //�������һֻ������������
			btns[x].setIcon(icon);
			flag = false;
			lastMouse = x;
		}
		
		//
		else if(box == source){
			String str = (String) box.getSelectedItem();
			if("����".equals(str)){
				level = 1000;
			}
			else if("�м�".equals(str)){
				level = 500;
			}
			else{
				level = 100;
			}
			mouseTimer = new Timer(level, this);
			
			
		}
		else{
			for(int i=0;i<btns.length;i++){
				if(btns[i]==source&&btns[i].getIcon()!=null&&!flag){
					String text = cent.getText();
					int num = Integer.parseInt(text);
					num++;
					cent.setText(num+"");
					flag = true;
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		new MouseTest2();
	}
}
