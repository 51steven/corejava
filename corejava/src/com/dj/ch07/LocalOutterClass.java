package com.dj.ch07;

/**
	�ֲ��ڲ��ࣺ</br>
		1���ֲ��ڲ���ֻ���ڵ�ǰ������ʹ�ã�</br>
		2���ֲ��ڲ����ʵ���ڲ���һ�������ܰ�����̬��Ա��</br>
		3���ھֲ��ڲ����ж�����ڲ���Ҳ���ܱ�public��protected��private��Щ���ʿ������η����Σ�</br>
		4���ֲ��ڲ����ʵ���ڲ���һ�������Է����ⲿ������г�Ա�����⣬�ֲ��ڲ��໹���Է������ڷ����е�final���͵Ĳ����ͱ�����
* */
public class LocalOutterClass {
	private String name;
	private static int age;

	public void say(){
		//(�ֲ�����,����ջ����,��һ�λ��ͷ�һ��)����Ҫ����ģ����ܻ�û����ͱ��ĵ��ˣ�����Ҫ����д������final���Σ��ŵ���������ȥ
		final int num = 10;    
//		public int num;
		name = "dj";
		//�ֲ��ڲ��ࣺ������࿴��һ���ֲ�����
		class LocalInner{
			private int age;
			public void hello(){
				//�����ⲿ���еĳ�Ա����
				System.out.println(LocalOutterClass.this.name);
				//�����ⲿ���еľ�̬��Ա����
				System.out.println(LocalOutterClass.age);
				//��������ֲ��ڲ����ڷ����е��Լ��ĳ�Ա����(����)
				System.out.println(num);
				//��������ֲ��ڲ����еľֲ�����
				System.out.println(this.age);
				//�����ⲿ���еķ���
				LocalOutterClass.this.test();
				//�����ⲿ���еľ�̬����
				LocalOutterClass.go();
			}
		}
		//
		//�����ֲ��ڲ���Ķ���
		LocalInner l = new LocalInner();
		//���þֲ��ڲ����з���
		l.hello();
	}
	public void test(){
		System.out.println("��ͨ����.......");
	}
	public static void go(){
		System.out.println("��̬����.......");
		
	}
	
	public static void main(String[] args) {
		new LocalOutterClass().say();
		
	}
}
