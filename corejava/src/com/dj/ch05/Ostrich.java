package com.dj.ch05;

public class Ostrich extends Bird{
	
	/*��д����ķ������������������б�һ��
	 * 
	 * */
	public void fly(){
		System.out.println("��ɲ����� ....");
	}
	
	public static void main(String[] args) {
		Ostrich os = new Ostrich();
		os.fly();
		
		System.out.println("........����...........");
		new Son();  //��ӡ Father()
	}
	
}
/*1.�����๹�췽������û��ʹ��this�ؼ��֣�����ʽ���ø�����޲ι��췽����
 *2.���๹������ʽ�ص��ø����Ĭ���޲ι�����;
 * 
 *3.new Son()-->������޲ι��캯��--> ������вι���-->�����޲ι���
 * */

class Father{
	public Father(){
		//super(); ��д�Ļ�Ҳ��Ĭ��������
		System.out.println("������޲ι���");
	}
	public Father(String name){
		System.out.println("�����вι���"+name);
	}
}

class Son extends Father{
	public Son(){
		//super("dj");
		this("dj2");
		System.out.println("������޲ι���");
	}
	public Son(String name){
		System.out.println("�����вι���"+name);
	}
}

