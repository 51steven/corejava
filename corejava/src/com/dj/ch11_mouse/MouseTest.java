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

public class MouseTest extends JFrame implements ActionListener{
	private static final long serialVersionUID = 8643166800318888102L;
	
	private Container container;
	private JPanel north;
	private JPanel center;
	private JComboBox<String> box;
	private JLabel timeLable,time,centLable,cent;
	private JButton start;
	
	private JButton[] btns;
	
	//ʱ��ĵ���ʱ
	private Timer timer;
	private ImageIcon icon;
	private Timer mouseTimer;
	private int level;
	
	//������ʾ��һ��������ֵ�λ��
	private int lastMouse = -1;
	//��ʾ��ǰ������ֵ�ʱ����û�е��мӷ� false true
	private boolean flag;
	
	public MouseTest() {
		//���ô��ڵĻ�������
		setTitle("�����");
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
		
		timeLable = new JLabel("time:");
		time = new JLabel("10");
		centLable = new JLabel("cent:");
		cent = new JLabel("0");
		start = new JButton("��ʼ");
		
		btns = new JButton[9];
		for(int i=0;i<btns.length;i++){
			btns[i] = new JButton();
			btns[i].setEnabled(false);
		}
		
		icon = new ImageIcon("src/com/dj/ch11_3/mouse.jpg");
		
		//���������Ĳ��ֹ�����
		north.setLayout(new FlowLayout());
		center.setLayout(new GridLayout(3, 3));
		container.setLayout(new BorderLayout());
		
		//�������ӵ�������
		north.add(box);
		north.add(timeLable);
		north.add(time);
		north.add(centLable);
		north.add(cent);
		north.add(start);
		
		for(int i=0;i<btns.length;i++){
			center.add(btns[i]);
		}
		container.add(north,BorderLayout.NORTH);
		container.add(center, BorderLayout.CENTER);
		//����¼�����
		start.addActionListener(this);
		for(int i=0;i<btns.length;i++){
			btns[i].addActionListener(this);
		}
		timer = new Timer(1000, this);
		level = 1000;
		mouseTimer = new Timer(level, this);
		box.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//ͨ���¼��������¼�Դ
		Object source = e.getSource();
		//�����start��ť�����¼�
		if(start == source){
			//�Ѱ�ť��Ϊ���õ� Ĭ���ǲ��ɵ����
			for(int i=0;i<btns.length;i++){
				btns[i].setEnabled(true);
			}
			//��Ϸ�����ܸı�
			box.setEnabled(false);
			//��ʼ��ť�����ٵ��
			start.setEnabled(false);
			//�ѿ�ʼʱ������Ϊ10
			time.setText("10");
			//�ѷ�������Ϊ0
			cent.setText("0");
			//����ʱ�䵹��ʱ
			timer.start();
			//������������ͷ��ʱ��
			mouseTimer.start();
		}
		//����ǵ���ʱ�����¼�
		else if(timer == source){
			String text = time.getText();
			int num = Integer.parseInt(text);
			if(num<=0){
				timer.stop();
				mouseTimer.stop();
				if(lastMouse != -1){
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
		//���������ʱ�������¼�
		else if(mouseTimer == source){
			if(lastMouse != -1){
				btns[lastMouse].setIcon(null);
			}
			int x = (int)(Math.random()*9);
			btns[x].setIcon(icon);
			//��ʾ��ǰ����ճ��� ��û�е���ӷ�
			flag = false;
			//��¼��ǰ������ֵ�λ��
			lastMouse = x;
			
		}
		//����������б�������¼�
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
		//����ǵ���������Щ��ť�������¼�
		else{
			
			for(int i=0;i<btns.length;i++){
				if(btns[i]==source && btns[i].getIcon()!=null && !flag){
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
		new MouseTest();
	}
}
