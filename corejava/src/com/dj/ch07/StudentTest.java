package com.dj.ch07;

public class StudentTest {
		public static void main(String[] args) {
			
			//== equals
			int a = 10;
			int b = 20;
			System.out.println(a==b);
			Student s1 = new Student(1L,"dj1");
			Student s2 = new Student(2L,"dj2");
			System.out.println(s1==s2);
			String str1 = "hello";
			String str2 = "hello";
			System.out.println(str1==str2);  //�Ƚϵ��Ǳ����е�ֵ
			String str3 = new String("hello");
			String str4 = new String("hello");
			System.out.println(str3==str4);	//�����е�ֵ��new��������ĵ�ַ
			System.out.println(str3.equals(str4));	//�Ƚϵ������ǵ�����
			
		}
}
