package com.dj.ch12_1;

//��������  ʹ��Runnable
public class RaceRunnable implements Runnable{
	//��̬���� ���ж������ flagΪtrueʱ���������
	private static boolean flag = false;
	private static String name = "";
	public void run(){
		int i = 1;
		int rand;
		for(;i <= 100;i++){	
			if(flag){
				break;
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
			rand = (int)(Math.random()*100 + 1);
			try{
				Thread.sleep(rand);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		flag = true;
	}
	public static void main(String[] args){
		Runnable r = new RaceRunnable();
		Thread rabbit = new Thread(r,"Rabbit");	
		Thread turtel = new Thread(r,"Turtel");
		System.out.println("Ready!Go!");
		rabbit.start();
		turtel.start();
		try{
			rabbit.join();
			turtel.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Game Over!");
	}
}
