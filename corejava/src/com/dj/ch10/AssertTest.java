package com.dj.ch10;

public class AssertTest {
	public static void main(String[] args) {
		AssertTest t = new AssertTest();
		t.test(-1);
		t.test(10);
	}
	//����  ����
	public void test(int a){
		assert a>0:"�����ڼ䴫ֵ";  //����һ��
		System.out.println(a);
	}
}
