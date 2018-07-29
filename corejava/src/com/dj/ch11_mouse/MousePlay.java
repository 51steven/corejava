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

/**
�����С��Ϸ��</br>
1���������������������ȵ�Ū�������Ҫʲô����ô���ְ������г���</br>
2���������</br>
		2.1�������ʼ��</br>
		2.2����������������У�����������������趨����</br>
		2.3������¼�</br>
3���¼�����</br>
	    3.1����ʼ��ť�������¼�</br>
	    3.2������ʱ�������¼�</br>
	    3.3����ʱ���������¼�</br>
	    3.4��������������¼�</br>
	    3.5���������������¼�</br>
* */
public class MousePlay extends JFrame implements ActionListener{
private static final long serialVersionUID = 1L;
private Container container;
private JPanel north;
private JPanel center;
private JComboBox<String> box;
private JLabel timeLable;
private JLabel time; 		   
private JLabel centeLable;     
private JLabel cente;          //����
private JButton start;         //��ʼ��ť
private JButton[] buts;        //�Ź���ť

private Timer timer;           //��ʱ��
private Timer mouseTimer;      //��������ͷ��ʱ��
private ImageIcon icon;        //����ͼ��

private int level;             //��Ϸ�Ѷ�
//������ʾ��һ��������ֵ�λ��
private int lastMouse = -1;
//��ʾ��ǰ������ֵ�ʱ����û�е��мӷ� false true
private boolean flag;

//1�����ڻ������Գ�ʼ��
public MousePlay() {
	setTitle("�����");
	container = getContentPane();
	setLocation(100, 100);
	setSize(300, 300);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(true);
	init();
	setVisible(true);
}
//2�� �������
public void init(){
	//1����ʼ�����
	north = new JPanel();
	center = new JPanel();
	box = new JComboBox<String>();
	box.addItem("����");
	box.addItem("�м�");
	box.addItem("�߼�");
	timeLable = new JLabel("time:");
	time = new JLabel("10");
	centeLable = new JLabel("center:");
	cente = new JLabel("0");
	start = new JButton("��ʼ");
	//Ĭ������ť������
	buts = new JButton[9];
	for(int i=0;i<buts.length;i++){
		buts[i] = new JButton();
		buts[i].setEnabled(false);
	}
	icon = new ImageIcon("src/com/ch04_mouse/mouse.jpg");
	north.setLayout(new FlowLayout());
	center.setLayout(new GridLayout(3, 3));
	container.setLayout(new BorderLayout());
	
	//2���������ӵ�������
	north.add(box);
	north.add(timeLable);
	north.add(time);
	north.add(centeLable);
	north.add(cente);
	north.add(start);
	for(int i=0;i<buts.length;i++){
		center.add(buts[i]);
	}
	container.add(north,BorderLayout.NORTH);
	container.add(center, BorderLayout.CENTER);
	//3������¼�
	start.addActionListener(this);
	for(int i=0;i<buts.length;i++){
		buts[i].addActionListener(this);
	}
	timer = new Timer(1000, this);
	level = 1000;
	mouseTimer = new Timer(level, this);
	box.addActionListener(this);
}
//3���¼�����
public void actionPerformed(ActionEvent e) {
	//ͨ���¼��������¼�Դ
	Object source = e.getSource();
	//��ʼ��ť�������¼�
	if(start.equals(source)){
		//����ť����
		for(int i=0;i<buts.length;i++){
			buts[i].setEnabled(true);
		}
		//��ʼ��ť�����ٵ��
		start.setEnabled(false);
		//��Ϸ�����ܸı�
		box.setEnabled(false);
		//�ѿ�ʼʱ������Ϊ10
		time.setText("10");
		//�ѷ�������Ϊ0
		cente.setText("0");
		//����ʱ�䵹��ʱ
		timer.start();
		//������������ͷ��ʱ��
		mouseTimer.start();
		
	}
	//����ʱ�������¼�
	else if(timer.equals(source)){
		int num = Integer.parseInt(time.getText());
		if(num<=0){
			//��ʱ��ֹͣʱ
			timer.stop();
			mouseTimer.stop();
			if(lastMouse != -1){
				buts[lastMouse].setIcon(null);
			}
			box.setEnabled(true);
			start.setEnabled(true);
			for(int i=0;i<buts.length;i++){
				buts[i].setEnabled(false);
			}
		}else{
			num--;
			time.setText(num+"");
		}
		
	}
	//��ʱ���������¼�
	else if(mouseTimer.equals(source)){
		if(lastMouse != -1){
			buts[lastMouse].setIcon(null);
		}
		int x = (int)(Math.random()*9);
		buts[x].setIcon(icon);
		//��ʾ��ǰ����ճ��� ��û�е���ӷ�
		flag = false;
		//��¼��ǰ������ֵ�λ��
		lastMouse = x;
	}
	//������������¼�
	else if(box.equals(source)){
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
	//�������������¼�
	else{
		for(int i=0;i<buts.length;i++){
			if(buts[i]==source && buts[i].getIcon()!=null && !flag){
				String text = cente.getText();
				int num = Integer.parseInt(text);
				num++;
				cente.setText(num+"");
				flag = true;
				break;
			}
		}
	}
}
public static void main(String[] args) {
	new MousePlay();
}
}
 