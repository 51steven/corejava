package com.dj.ch13_4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@SuppressWarnings("unchecked")
public class MyCloneUtil {
	private MyCloneUtil() {
		throw new AssertionError(); 
	} 
	public static <T extends Serializable> T clone(T obj) throws Exception { 
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bout); 
		oos.writeObject(obj); 
		ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bin);
		return (T) ois.readObject(); 
		//˵��������ByteArrayInputStream��ByteArrayOutputStream�����close����û���κ����� 
		//�����������ڴ����ֻҪ�������������������ܹ��ͷ���Դ����һ�㲻ͬ�ڶ��ⲿ��Դ�����ļ��������ͷ� 
	}
	
	public static void CloneTest(){
		try { 
			Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300)); 
			Person p2 = MyCloneUtil.clone(p1); //��ȿ�¡ 
			p2.getCar().setBrand("BYD");  
			//�޸Ŀ�¡��Person����p2���������������Ʒ������ 
			//ԭ����Person����p1���������������ܵ��κ�Ӱ�� 
			//��Ϊ�ڿ�¡Person����ʱ���������������Ҳ����¡��
			System.out.println(p1); 
			} catch (Exception e) { 
				e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args) {
		CloneTest();
	}
	
}
