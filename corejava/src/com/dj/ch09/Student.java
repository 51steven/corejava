package com.dj.ch09;

public class Student {
	private String pri_name = "pri";
	String def_name = "def";
	protected String pro_name = "pro";
	public String pub_name = "pub";
    public String getPri_name() {
		return pri_name;
	}
	public void setPri_name(String pri_name) {
		this.pri_name = pri_name;
	}
	public void say(){
		System.out.println("û�Σ�д��������һ�¿�...........");
	}
	public void say(String msg,int age){
		System.out.println(msg+"   �вΣ�������ôд��.............."+age);
	}
	public void run(){
		System.out.println("Ҫ��ʣ����ܲ�����.............");
	}
	public Student(){
		
	}
	public Student(String pri_name){
		this.pri_name = pri_name;
	}
	
}
