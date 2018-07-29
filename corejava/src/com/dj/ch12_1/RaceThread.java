package com.dj.ch12_1;

//��������  ʹ�� Thread
public class RaceThread extends Thread{
	//��̬���� ���ж������ flagΪtrueʱ���������
	private static boolean flag = false;
	private static String name = "";
	public RaceThread(String name){
		super(name);
	}
	public void run(){
		int rand;
		for(int i=1;i <= 100;i++){
			if(flag){
				break;
			}
			System.out.println(getName() + ":" + i);
			if(i==100){
				name = getName();
			}
			//ÿ������һ����Ҫ�����Ϣһ��
			rand = (int)(Math.random()*100 + 1);
			try{
				sleep(rand);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		flag = true;
	}
	public static void main(String[] args){
		Thread rabbit = new RaceThread("Rabbit");	
		Thread turtle = new RaceThread("Turtel");
		System.out.println("Ready!Go!");
		rabbit.start();
		turtle.start();
		try{
			//���߳�Ҫ����������̶߳�������֮����ܽ���
			rabbit.join();
			turtle.join();	
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(name+" to win the match!");
		System.out.println("Game Over!");
	}
}
