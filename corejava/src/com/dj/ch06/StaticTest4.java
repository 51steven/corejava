package com.dj.ch06;

/*��̬�����������������(����Ҫ�õľ�ǡ���ô����ʵ����ã�ռ�ڴ�),�Ǿ�̬�����ڶ����
 * 
 * */
public class StaticTest4 {
	public static int a; 
	private int b;

	public void test(){
		a++;
		b++;
		System.out.println("a="+a);
		System.out.println("b="+b);
	}

	public static void main(String[] args){
		
		//System.out.println("");
		StaticTest4 s1 = new StaticTest4();
		s1.test();
		StaticTest4 s2 = new StaticTest4();
		s2.test();
		StaticTest4 s3 = new StaticTest4();
		s3.test();
		StaticTest4 s4 = new StaticTest4();
		s4.test();
	}
}
