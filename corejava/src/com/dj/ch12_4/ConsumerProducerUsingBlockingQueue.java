package com.dj.ch12_4;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ���������������⣨��������ʵ�֣���</br>
 * �߳��������У�����ͼ��һ�����������Ԫ�ػ��ߴӿն�����ɾ��Ԫ��ʱ�ᵼ���߳�����
 * 		put():�ڶ�β����һ��Ԫ�أ�������������ȴ�
 * 		take():���ز�ɾ��������е�ͷ���������Ϊ����ȴ�
 * ����������������У�
 * 		ArrayBlockingQueue:��������ʵ�֡�����ָ��һ���������߿�ѡ�Ĺ�ƽ��������ArrayBlockingQueue
 * 		LinkedBlockingQueue:������ʵ�֡����������������޻����޵�LinkedBlockingQueue
 * 		PriorityBlockingQueue�����ȶ��С����Դ��������޵Ļ����������ȵĶ���
 * ���ڲ����޵Ķ��У�put������Զ��������
 * */
public class ConsumerProducerUsingBlockingQueue {
	private static ArrayBlockingQueue<Integer> buffer = new ArrayBlockingQueue(2);
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}
	
	private static class ProducerTask implements Runnable{
		public void run() {
			try {
				int i=1;
				while(true){
					System.out.println("������д������"+i);
					buffer.put(i++);
					Thread.sleep((int) (Math.random()*10000));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private static class ConsumerTask implements Runnable{
		public void run() {
			try {
				while(true){
					System.out.println("�����߶�������"+buffer.take());
					Thread.sleep((int) (Math.random()*10000));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
