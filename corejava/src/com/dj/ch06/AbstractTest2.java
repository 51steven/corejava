package com.dj.ch06;

//�������ǲ�����new�ؼ��ִ��������,����newʵ��
public abstract class AbstractTest2{
	private String name;
	public static int age;

	public abstract void say(); 
	
	public void test(){
		System.out.println("test...");	
	}

	public static void println(){
		System.out.println(age+" gogo");
	}

	public static void main(String[] args){
		/*
		System.out.println("hello world");
		AbstractTest3.println();
		AbstractTest3 a = new AbstractTest3();
		a.test();
		*/
		AbstractTest2 a = new D();
		a.say();
		a.test();
	}
}

class D extends AbstractTest2{

	public void say(){
		System.out.println("say.....");	
	}
}



