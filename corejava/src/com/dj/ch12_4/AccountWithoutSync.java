package com.dj.ch12_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �߳�ͬ����</br>
 *        ʹ��synchronized����������ʹ���໥�ų����ʾ����ЩȻ����
 *        ��ʾ����ͬ������״̬���̸߳�����ֱ��(�̼߳��Э��)
 * */
public class AccountWithoutSync {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0;i<100;i++){
			executor.execute(new AddPennyTask());
		}
		executor.shutdown();
		//�����߳��Ƿ���ֹ
		while(!executor.isTerminated()){
		}
		System.out.println("what is balance?"+account.getBalance());
	}
	/**
	 * ����һ����account������penny���߳�(��̬�ڲ���)</br>
	 * */
	private static class AddPennyTask implements Runnable{
		public void run() {
			account.deposit(1);
		}
	}
	/**
	 * �˻���(��̬�ڲ���)</br>
	 * 1����ʾ��
	 * 2���ź������ź����������Ʒ��ʹ�����Դ���߳�����
	 * 		        �ڷ�����Դ֮ǰ���̱߳�����ź�������ȡ��ɣ���������Դ֮������̱߳��뽫��ɷ��ظ��ź���
	 * 	  Semaphore(numberOfPermits:int):����һ����ָ����Ŀ��ɵ��ź�������ƽ����Ϊfalse
	 * 	  Semaphore(numberOfPermits:int,fair:boolean):����һ����ָ����Ŀ��ɺ͹�ƽ���Ե��ź���
	 * 	  acquire():��ȡ����ź�������ɣ����û����ɿ��ã��߳̾ͱ���סֱ���п������Ϊֹ
	 * 	  release():�ͷ�һ����ɸ����ź���
	 * ֻ��һ����ɵ��ź�����������ģ��һ���໥�ų����		
	 * */
	private static class Account{
		private int balance=0;
		//����һ������ʾ��
		private static Lock lock = new ReentrantLock();
		//�����������ź���
//		private static Semaphore semaphore = new Semaphore(1);
		public int getBalance() {
			return balance;
		}
		/**
		 * ��account������penny
		 * */
		public void deposit(int amount) {
			lock.lock();
			try {
//				semaphore.acquire();
				int newBalance = balance+amount; 
				Thread.sleep(5);
				balance = newBalance;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally{
				lock.unlock();//�ͷ���
//				semaphore.release();
			}
		}
	}
}
