package com.dj.ch09;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectTest {
	public static void main(String[] args) throws Exception {
		Student s = new Student("dj");
		
		//���һ�����Class���Ͷ���
		Class c1 = s.getClass();   //��������Ѿ�����Class��ʵ������
		Class c2 = Student.class;
		
		String className = "ch09.Student"; //�������û��Class��ʵ������,ͨ������.properties�ļ��еİ�������������
		Class c3 = Class.forName(className);
		
/*		//�������Գ����࣬�ͷ���Ȩ�޵�����
		Field f = c1.getField("pub_name");
//		Field f2 = c1.getField("pri_name");  //ֻ��public����ֱ�ӷ��ʣ�˽��...���ԣ������÷���Ȩ�޿ɷ��ʵ� setAccessible()
		System.out.println(f.getType());
		System.out.println(f.getModifiers()); //������η�����ֵ
		System.out.println(f.getName()); //������η�����ֵ
		System.out.println(f.get(s)); //������η�����ֵ,�������棺����.get(�������ԵĶ���)
		System.out.println("............................");
		
		Field[] fields = c1.getDeclaredFields();
		for(Field fi:fields){
			fi.setAccessible(true);//����˽�����ԵȵĿɼ���
			System.out.println(fi.getType());
			System.out.println(fi.getModifiers());
			System.out.println(fi.getName());
			System.out.println(fi.get(s));
		}*/
		
		//����������
		@SuppressWarnings("unchecked")
		Method method1 = c1.getMethod("say"); //���Method��Ķ���
		method1.invoke(s); //invoke()ͨ��Student�Ķ���s�ҵ�Student���еķ��� 
		//ͨ���������Ͳ����б��������б��װ��һ��Class����ȷ����Ҫ�ķ���
		@SuppressWarnings("unchecked")
		Method method2 = c1.getMethod("say",new Class[]{String.class,int.class});
		method2.invoke(s,new Object[]{"dj",6});
		
	/*	//�޲ι��캯��
		Student o = (Student) c1.newInstance();
		ReflectTest re = new ReflectTest();
		Student stu1 = (Student) re.getObj("com.dj.ch06_4.Student");
		stu1.run();*/
		
		//�вι���
		Constructor constructor = c1.getConstructor(new Class[]{String.class});
		Student stu1 = (Student) constructor.newInstance(new Object[]{"dj"});
		System.out.println(stu1.getPri_name());
	}
	
	
	//String name = "Student" 
	//com.dj.ch06_4.Student
	public Object getObj(String className) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Class c = Class.forName(className);
		Object o = c.newInstance();
		return o;
//		return Class.forName(className).newInstance();
	}

	
}
