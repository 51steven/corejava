package com.dj.ch05;

public class Teacher {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Teacher(){
		this(12);
//		super();   //��ѡһ����ֻ�ڵ�һ��
		new Teacher("dj",12);
		this.setAge(12);
	}
	public Teacher(String name){
		super();	//��ǰ������๹����ͨ��super()����
					//���๹�������ø��๹����ֻ���ø�������Ժͷ���������������ֻ������ᴴ������
		this.name = name;
	}
	public Teacher(int age){
		this("dj",12);	//�ڹ���������this������һ�����صĹ�����
	}
	public Teacher(String name,int age){
		//new Teacher("dj",20); //��new�ؼ��ֵ��ù������������¶���
		this.name = name;
		this.age = age;
	}
	
}
