package com.dj.ch07;

/**
	��̬�ڲ��ࣺ</br> 
		1����̬�ڲ����в���ֱ�ӷ����ⲿ��ķǾ�̬���Ի��߷����� ��̬�ڲ���Ķ�����Ҫ�������ⲿ��Ķ���</br>
		2����̬�ڲ������ֱ�ӷ����ⲿ��ľ�̬��Ա����������ⲿ���ʵ����Ա���ͱ���ͨ���ⲿ���ʵ��ȥ���ʣ�</br>
		3���ھ�̬�ڲ����п��Զ��徲̬��Ա��ʵ����Ա��</br>
		4������ͨ������������ֱ�ӷ��ʾ�̬�ڲ���ľ�̬��Ա��
* */
public class StaticOutterClass {
	private String name;
	private static int age;
	
	//��̬�ڲ��ࣺ������̬�ĳ�Ա����
	//�ڲ��࿪ʼ
	public static class StaticInner{
		private String name;
		//��̬�ڲ����п����о�̬�ı����򷽷�
		private static int age;
		public void say(){
			//�����ڲ���ĳ�Ա����
			System.out.println(this.name);
			System.out.println(this.age);
			//���Է����ⲿ���еľ�̬�����Ի򷽷�
			System.out.println(StaticOutterClass.age);
			System.out.println(StaticOutterClass.StaticInner.age);
			StaticOutterClass.hello();	
			//���ܷ����ⲿ���еķǾ�̬������(��̬�����ǲ������ķ��ʷǾ�̬��)
//			System.out.println(StaticOutterClass.this.name);
//			StaticOutterClass.say();
			new StaticOutterClass().say();
//			StaticOutterClass.this.say;
			new StaticOutterClass().hello();
			StaticOutterClass.hello();
//			StaticOutterClass.this.say();
			new StaticInner();
//			new StaticOutterClass().new StaticInner();
		}
	}
	//�ڲ������
	public void say(){
		//�ⲿ���з��ʾ�̬�ڲ���ľ�̬����
		System.out.println(StaticInner.age);
		//�ⲿ���з��ʾ�̬�ڲ���ķǾ�̬���Ի򷽷�
		//��Ҫ�����ھ�̬�ڲ���Ķ���
		StaticInner st = new StaticInner();
		System.out.println(st.name);
	}
	public static void hello(){
		
	}
	public static void main(String[] args) {
		StaticInner staticInner = new StaticInner();
		staticInner.say();
		StaticInner staticInner2 = new StaticOutterClass.StaticInner();
//		StaticOutterClass.StaticInner	//�������
//		new StaticOutterClass().new StaticInner();
		
	}
	
}
