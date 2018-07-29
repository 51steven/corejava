package com.dj.ch13_4;

import java.io.Serializable;

public class Student implements Serializable{
	/**
	 * ������л���ţ������Ժ�����޸�������
	 * ���û�����л���ţ��޸������е����ԵȵĻ��ͻᱨ��
	 */
	private static final long serialVersionUID = -7854393115582398207L;
	private long id;
	private String name;
	//transient��͸���ģ�������Ե�ֵ�����л���ʱ��ᱻ����,���˵�ageֵ����Ů����������˽
	private transient int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Student(long id, String name,int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Student() {
	}
	public String toString() {
		return "id="+id+",name="+name+",age="+age;
	}
	
}
