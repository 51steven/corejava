package com.dj.ch12_5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * Copy-On-Write���COW����һ�����ڳ�������е��Ż����ԡ������˼·�ǣ���һ��ʼ��Ҷ��ڹ���ͬһ�����ݣ���ĳ������Ҫ�޸�������ݵ�ʱ��
 * �Ż�����������Copy��ȥ�γ�һ���µ�����Ȼ���ٸģ�����һ����ʱ������ԡ�
 * 
 * */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ArrayListOfMultithread {
	
	/**
	 * ���ֱ�����ʽ������
	 * 	 	����ʹ��Iterator���б������Ҷ���ͨ��ArrayList.remove(Object) ����ɾ��������
	 * 		list�ڱ�����ʱ�����ɾ����������ظ�ɾ��������
	 * 		�����ArrayListԴ�룬Ϊʲô���׳�ConcurrentModificationException�쳣
	 * */
	public static void originalList(){
		ArrayList<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		//������ʽ1
		Iterator<String> it1 = list.iterator();
		while(it1.hasNext()){
			String next = it1.next();
			if(next.equals("3")){
				list.remove(next);
			}
		}
		//������ʽ2
		//list.iterator(): ��ȡһ���������е�ǰλ�õĶ���
		//it2.hasNext(): �������к����Ƿ��ж���
		for(Iterator<String> it2 = list.iterator();it2.hasNext();){
			String next = it2.next();
			if(next.equals("3")){
				list.remove(next);
			}
		}
		//������ʽ3
		for (String next : list) {
			if (next.equals("3")) {
				list.remove(next);
			}
		} 
	}
	
	public static void singleThreadTest(){
		ArrayList<String> list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		// 1 ʹ��Iterator�ṩ��remove����������ɾ����ǰԪ��  
		/*for (Iterator<String> it = list.iterator(); it.hasNext();) {
			String next = it.next();
			if (next.equals("3")) {
				it.remove();	//�ؼ�
			}
		}*/
		
		// 2 ��һ�����ϣ���¼��Ҫɾ����Ԫ�أ�֮��ͳһɾ��             
		/*List<String> templist = new ArrayList<String>();
		for (String value : list) {
			if (value.equals("3")) {
				templist.add(value);
			}
		} 
		// ���Բ鿴removeAllԴ�룬����ʹ��Iterator���б��� 
		list.removeAll(templist); */
		
		// 3. ��ʹ��Iterator���б�������Ҫע������Լ���֤��������
		for (int i = 0; i < list.size(); i++) {
			String value = list.get(i);
			if (value.equals("3")) {
				list.remove(value);
				i--;  // ��Ϊλ�÷����ı䣬���Ա����޸�i��λ�� 
			}
		}
		System.out.println("next Value:" + list.toString());
		
		//4. ʹ���̰߳�ȫCopyOnWriteArrayList����ɾ������
		/*List<String> myList = new CopyOnWriteArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			String value = it.next();
			if (value.equals("3")) {
				myList.remove("4");
				myList.add("6");
				myList.add("7");
			}
		}
		System.out.println("List Value:" + myList.toString());*/
		
	}
	
	public static void multiThreadTest() {
		final List<String> myList = new CopyOnWriteArrayList<String>();
		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (String string : myList) {
					System.out.println("�������� value = " + string);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		//ʵ��
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < myList.size(); i++) {
					String value = myList.get(i);
					System.out.println("ɾ��Ԫ�� value = " + value);
					if (value.equals("3")) {
						myList.remove(value);
						System.out.println("�Ƴ�Ԫ��    	value = " + value);
						i--;  // ע��  
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	public static void main(String[] args) {
//		originalList();
//		singleThreadTest();
		multiThreadTest();
		
	}
	

}
