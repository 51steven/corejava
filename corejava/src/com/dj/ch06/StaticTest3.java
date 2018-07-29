package com.dj.ch06;

/**
<code>newһ�������ʱ��JVM��������Щ����:</code></br>
<code>1.</code></br>
<code>2.</code></br>
* */
public class StaticTest3 {

	private static String name;
	private int age;
	
	//���������
	{
		name = "tom";
		age = 30;
		System.out.println("���������...");	
	}
	//��̬�����
	static{
		name = "tom";
//		age = 12; //false
		//new StaticTest3();
		System.out.println("��̬�����..."+name);	
	}
	//�޲ι���
	public StaticTest3() {
		this.name = "zhangsan";
		this.age = 20;
		System.out.println("�޲ι��췽��...name="+name+" age="+age);	
	}
	//ʵ������
	public void test(){
		name = "zhangsan";
		System.out.println("ʵ������..."+name);
	}
	//��̬����
	public static void say(){
		name = "zhangsan";
		System.out.println("��̬����..."+name);
	}
	
	public static void main(String[] args) {
//		System.out.println(name);    //1.
		new StaticTest3(); 			 //2.
//		say();			  		     //3.
//		new StaticTest3().test();    //4.
		
	}

}
