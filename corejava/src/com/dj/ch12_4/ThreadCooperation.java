package com.dj.ch12_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �̼߳��Э����</br>
 *    ʹ�����������̼߳��ͨ��
 *    һ���߳̿���ָ����ĳ�������¸���ʲô��������ͨ��Lock�����newCondition()�����������Ķ���
 *    һ���������������Ϳ���ʹ��await()��signal()..�ȷ�����ʵ���߳�֮���ͨ��
 * ���棺û��������͵�����Щ����������׳��쳣
 * await():��ǰ�̵߳ȴ�ֱ������ĳ������
 * signal():����һ���ȴ��߳�
 * */
public class ThreadCooperation {
	private static Account account = new Account();
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new DepositTask());
		executor.execute(new WithdrawTask());
		executor.shutdown();
		System.out.println("�߳�һ���̶߳��Ľ��...");
	}
	/**
	 * ��Ǯ
	 * */
	public static class DepositTask implements Runnable{
		public void run() {
			try {
				while(true){
					account.deposit((int) (Math.random()*10+1));
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ȡǮ
	 * */
	public static class WithdrawTask implements Runnable{
		public void run() {
			while(true){
				account.withdraw((int) (Math.random()*10+1));
			}
		}
	}
	/**
	 * �˻�
	 * */
	private static class Account{
		private static Lock lock = new ReentrantLock();
		//ͨ��lock�����newCondition()����,����һ������
		private static Condition newDeposit = lock.newCondition();
		private int balance = 0;
		public int getBalance(){
			return balance;
		}
		/**ȡǮ*/
		public void withdraw(int amount){
			//Ϊ��ͬ����Щ������ʹ��һ��������������newDeposit(���ӵ��˻����´��)��
			//ʹ�������ͱ����Ȼ����
			lock.lock();
			try {
				while(balance<amount){
					System.out.println("�ȴ��û���Ǯ");
					newDeposit.await();
				}
				balance -=amount;
				System.out.println("ȡ��"+amount+"Ԫ����ʣ"+getBalance()+"Ԫ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}
		/**��Ǯ*/
		public void deposit(int amount){
			lock.lock();
			balance+=amount;
			System.out.println("����"+amount+"Ԫ����ʣ��"+getBalance()+"Ԫ");
			newDeposit.signalAll();
			lock.unlock();
		}
	}
}
