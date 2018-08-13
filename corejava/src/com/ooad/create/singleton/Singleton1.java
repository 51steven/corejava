package com.ooad.create.singleton;

//����ģʽ(�ھ�̬������ʵ��������)
public class Singleton1 {
	//1.���ж���һ��private static���εĵ�ǰ������͵ı���
	private static Singleton1 sing;

	//2.��ǰ��Ĺ�������private����
    private Singleton1() {
        
    }
    
    //3.�ṩһ��public static���εķ���,������õ�ǰ��ĵ�������.
    public static Singleton1 getInstance() {
        if (sing == null) {
            sing = new Singleton1();
        }
        return sing;
    }

}
