package com.dj.ch11_2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//�����̳���JFreme��,�Ϳ���ֱ�ӵ���JFrame�еķ���
public class ProgressBarTest extends JFrame{
	private Container container;
	//һ����ǩ���� ���Է�����
	private JLabel label;
	//������
	private JProgressBar bar;
	//��ʾΪ���صİ�ť
	private JButton button;
	//��ʱ��,ÿ��һ��ʱ����԰�������һ������
	//ֱ�����������÷����ö�ʱ��ͣ����Ϊֹ
	private Timer timer;
	
	public ProgressBarTest(){
		container = getContentPane();
		setBounds(40,40,200,30);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		setVisible(true);
		//�Զ�����������ʵĴ�С��λ��
		pack();
	}
	
	private void init(){
		label = new JLabel("�����ť����");
		button = new JButton("����");
		bar = new JProgressBar();
		//���ý������е�ֵ��ʼΪ0
		bar.setValue(0);
		//��СֵΪ0
		bar.setMinimum(0);
		//���ֵΪ100
		bar.setMaximum(100);
		//��ʾ��ǰ��������״̬
		bar.setStringPainted(true);
		
		//��container��������
		container.add(button,BorderLayout.NORTH);
		container.add(bar);
		container.add(label,BorderLayout.SOUTH);
		
		//������ʱ������,��ָ����ʱ��ÿ1����ʲô����
		timer = new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ý������е�ǰ��ֵ
				int value = bar.getValue();
				
				//�жϽ������е�ǰ��ֵ�Ƿ�С��100
				if(value<100){
					//value��10
					value+=10;
					//�����õ���������
					bar.setValue(value);
				}else {
					//��ʱ��ֹͣ����
					timer.stop();
					//��ťλ��Ϊ����
					button.setEnabled(true);
				}
			}
		});
		
		//����ť����¼�����:�����ť��ʱ����ʲô����
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ʱ������
				timer.start();
				//�ð�ť����ʹ��
				button.setEnabled(false);
				//�ѽ������е�ǰ��ֵ��������Ϊ0
				bar.setValue(0);
			}
		});
		
		//�����������һ�������� :������ÿ��״̬�ı�ʱ����ʲôʱ��
		bar.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				//��ý������е�ֵ
				int value = bar.getValue();
				//�����ֵ���õ�label��
				label.setText("������"+value+"%");
			}
		});
		
	}
	public static void main(String[] args) {
		new ProgressBarTest();
	}
	
}
