package com.dj.ch08.lx_01;

public abstract class Animal {

	protected int legs;
	protected Animal(int legs) {
		this.legs = legs;
		System.out.println("���м�ֻ��");
	}
	public void walk(){
		System.out.println("�ĸ���������·");
	}
	public abstract void eat();
	
}
