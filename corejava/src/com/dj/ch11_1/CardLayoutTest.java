package com.dj.ch11_1;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//��Ƭ���ֹ�����
public class CardLayoutTest {
	private JFrame frame;
	private Container container;
	private JPanel panel;
	private JPanel[] jPanels;
	
	public CardLayoutTest() {
		frame = new JFrame();
		container = frame.getContentPane();
		frame.setLocation(50,50);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		frame.setVisible(true);
	}
	private void init(){
		panel = new JPanel();
		
		container.add(panel);
		
		jPanels = new JPanel[4];
		
		jPanels[0] = new JPanel();
		jPanels[0].setBackground(Color.red);
		
		jPanels[1] = new JPanel();
		jPanels[1].setBackground(Color.blue);
		
		jPanels[2] = new JPanel();
		jPanels[2].setBackground(Color.black);
		
		jPanels[3] = new JPanel();
		jPanels[3].setBackground(Color.gray);
		
		panel.setLayout(new CardLayout());
		
		//��CardLayout���ֹ������з��������ʱ��һ��Ҫ�������һ������
		panel.add("0",jPanels[0]);
		panel.add("1",jPanels[1]);
		panel.add("2",jPanels[2]);
		panel.add("3",jPanels[3]);
		
		//��Ӽ����� �����������֮���з�Ӧ
		addLister(panel);
		
	}
	//addLister���������Ϊ�˸�panel���һ��������¼�
	private void addLister(JPanel panel2) {
		
		/*newһ�������������ӿڵ�ʵ���࣬�Ϳ��Բ�����д�ӿ��е����еķ���
		 * ֻҪд�Լ���Ҫ�ķ����ͺ���
		 * */
//		panel.addMouseListener(new MouseListener() {};
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//���panel��������Ĳ��ֹ����� 
				//��תΪCardLayout���͵Ķ���
				CardLayout cl = (CardLayout) panel.getLayout();
				
				//��ʾCardLayout�������е���һ�����
				//���������ʾ:����һ�����������õ����CardLayout������
				cl.next(panel);
//				cl.show(panel, "3");
			}
		
		});
		
		
	}

	public static void main(String[] args) {
		
		new CardLayoutTest();
	}

}