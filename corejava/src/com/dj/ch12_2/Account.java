package com.dj.ch12_2;
/**���˹��������˻�*/
public class Account {
	/**�˻����*/
	private int balance;
	public Account(int balnace) {
		this.balance = balnace;
	}
	/**
	 * ��Ǯ</br>
	 * @param money
	 * */
	public synchronized void pos(int money){
		this.balance+=money;
		String name = Thread.currentThread().getName();
		System.out.println(name+" ����"+money+"�����˺Ź���"+balance+"Ԫ");
		//wait������notifyAll�������ǵ����������е�,��ǰ����������this,����ֱ�ӵ��õ�ǰ����this�еķ���
		//�����Class����,��ô��Ҫ����Class�����wait����notifyAll����
		super.notifyAll();
	}
	/**
	 * ����
	 * @param money
	 * */
	public synchronized void wit(int money){
		while(balance-money<0){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance-=money;
		String name = Thread.currentThread().getName();
		System.out.println(name+" ������"+money+"��ʣ��"+balance+"Ԫ");
	}
	
/*	public void pos(int money){
		this.balance+=money;
		String name = Thread.currentThread().getName();
		System.out.println(name+" ����"+money+"�����˺Ź���"+balance+"Ԫ");
	}
	public  void wit(int money){
		balance-=money;
		String name = Thread.currentThread().getName();
		System.out.println(name+" ������"+money+"��ʣ��"+balance+"Ԫ");
	}
   */
}
