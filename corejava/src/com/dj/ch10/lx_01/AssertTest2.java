package com.dj.ch10.lx_01;

public class AssertTest2 {
	public static void main(String[] args) {
		args = new String[3];
		System.out.println(args.length==2);
		
			assert args.length==2:"main�����Ĳ����պ�������";
			System.out.println(args.length);
	}
}
