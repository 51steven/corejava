package com.dj.ch07;

/**
	�����ڲ���:</br> 
		1��д�ڳ�Ա�����е������ڲ��� ���ӿڵ�ʵ��</br>
		2��д�ڷ����е������ڲ��࣬�������ڲ���ֻ�������������ʹ��
* */
public class AnonymousOutterClass {
	private String name;
	private static int age;
	/**
	 * д�ڳ�Ա�����е������ڲ��ࣨ�ӿڵ�ʵ�֣�û�����֣�
	 * ����֧�֣���ʹ�ýӿ��������������ͱ���ʱ��������ñ����������õ�ʵ����Ķ���
	 *
	 * ���������ж�����ʹ��
	 * SomeThing�Ƕ��������java�ļ��еĽӿ�
	 * */
	private SomeThing  s = new SomeThing() {
		
		@Override
		public void use() {
			System.out.println("д�ڳ�Ա�����е������ڲ���...");
		}
	};
public void say(){
	
	int num = 10;
	final int num2 = 10;
	//д�ڷ����е������ڲ��࣬�������ڲ���ֻ�������������ʹ��
	SomeThing s2 = new SomeThing() {
		
		@Override
		public void use() {
			System.out.println(AnonymousOutterClass.this.name);
			System.out.println(AnonymousOutterClass.age);
			System.out.println(num2);
		}
		public void say(){
			
		}
	};
	s2.use();
	}

	public static void main(String[] args) {
		new AnonymousOutterClass().s.use();
		
	}
}

interface SomeThing{
	void use();
}