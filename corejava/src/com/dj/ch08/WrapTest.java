package com.dj.ch08;

public class WrapTest {
	public static void main(String[] args) {
		String a = "1";
		Integer i = new Integer(a);
		
		//�Զ�װ�䣬jdk1.5�Ժ���е�������
		Integer t = 1;
		//�Զ�����
		int t2 = t;
		String b = 1+"";	//�����ͱ���ַ���
		Integer.parseInt(a); //���������ַ������������
		
		WrapTest w = new WrapTest();
		Integer ii = new Integer(1);
		w.test(ii);
		w.test(1L);
		w.test(1);
	}
	//�������͵�ת������ʾ����ʽ�����䡢װ�䣺���� �������͵�ת�����ͻ����������Ͱ�װ�ࣨ�ࣩ���������û������
//	public void test(Object o){
//		System.out.println("1");
//	}
//	public void test(int i){
//		System.out.println("2");
//	}
	public void test(long l){
		System.out.println("3");
	}
	public void test(Long L){
		System.out.println("4");
	}
	
	
}
