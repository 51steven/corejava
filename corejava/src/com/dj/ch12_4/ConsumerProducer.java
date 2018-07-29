package com.dj.ch12_4;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *�����ߡ����������⣨�Զ������ʵ�֣�:</br>
 * 	����ʹ�û������洢�������������Ĵ�С�����޵�
 * 	�������ṩwrite(int)������һ��intֵ��ӵ��������У����ṩ��read()�����ӻ������ж�ȡ��ɾ��һ��intֵ
 * Ϊ��ͬ��������ʹ�þ�����������������notEmpty()��notFull()
 * 		�������򻺳������һ��intʱ����������������ģ���ô���񽫻�ȴ�notFull״̬��
 * 		��.........ɾ��..................�յģ�............notEmpty״̬��
 * */
public class ConsumerProducer {
	private static Buffer buffer = new Buffer();
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new CunsumerTask());
		executor.shutdown();
	}
	
	/**
	 * �����ߣ��򻺳���������һ��int������
	 * */	
	private	static class ProducerTask implements Runnable{
		public void run() {
			try {
				int i = 1;
				while(true){
					System.out.println("������д������"+i);
					buffer.write(i++);
					Thread.sleep((int) (Math.random()*10000));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * �����ߣ���建������ɾ��һ��int������
	 * */
	private static class CunsumerTask implements Runnable{
		public void run() {
			try {
				while(true){
					System.out.println("�����߶�������"+buffer.read());
					Thread.sleep((int) (Math.random()*10000));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static class Buffer{
		/**buffer�Ĵ�С*/
		private static final int CAPACITY = 1;
		/**������ʵ������һ���Ƚ��ȳ��Ķ���*/
		private LinkedList<Integer> queue = new LinkedList();
		
		private static Lock lock =new ReentrantLock();
		//״̬����������һ����Ӧ��һ��״̬֮ǰ�����ȡһ����
		private static Condition notEmpty = lock.newCondition();
		private static Condition notFull = lock.newCondition();

		public void write(int value){
			lock.lock();
			try {
				while(queue.size()==CAPACITY){
					System.out.println("�ȴ�notFull����");
					notFull.await(); //��ɵ�ǰ�߳��ڽӵ��źŻ��ж�֮ǰһֱ���ڵȴ�״̬��
				}
				queue.offer(value); //��ָ��Ԫ����ӵ����б��ĩβ�����һ��Ԫ�أ�
				notEmpty.signal(); //����һ���ȴ��߳�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
		}
		public int read(){
			int value = 0;
			lock.lock();
			try {
				while(queue.isEmpty()){
					System.out.println("�ȴ�notEmpty����");
					notEmpty.await();
				}
				value=queue.remove();
				notFull.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
			return value;
		}
	}
}


