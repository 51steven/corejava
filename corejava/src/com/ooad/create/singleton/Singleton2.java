package com.ooad.create.singleton;

//����ģʽ(ֱ�Ӹ���̬��Ա����ʵ��������)
public class Singleton2 {
	//1.���ж���һ��private static���εĵ�ǰ������͵ı���(δ��ʼ��)
	private static Singleton2 sing = new Singleton2();
	//2.��ǰ��Ĺ�������private����
    private Singleton2() {
        
    }
    //3.�ṩһ��public static���εķ���,������õ�ǰ��ĵ�������.
    public static Singleton2 getInstance() {
        return sing;
    }

}
