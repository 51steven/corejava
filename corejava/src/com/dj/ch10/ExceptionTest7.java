package com.dj.ch10;

public class ExceptionTest7 {
	
	public static void main(String[] args) {
		//����ʱ�쳣
		String s = null;
		if(s!=null){
			System.out.println(s.trim());
		}
		
		//����ʱ�쳣
		try {
			Class.forName("com1.briup.ch07.ExceptionTest7");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void test()throws ClassNotFoundException,ArithmeticException,NoSuchFieldException{
		
	}
	
	
	
}
