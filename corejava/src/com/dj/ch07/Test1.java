package com.dj.ch07;

public class Test1 {
	public static void main(String[] args) {
		
		/*String���ͱ�����ֵ�������=���ұ��ǰ���������Ԫ�أ���ô����ȥ���������
		ȥ��Ԫ�أ������=���ұ��ǳ�����ô�ͻ�ȥ������ȥ��������ȵ�Ԫ�أ�*/
		
		String c = "c";		//��ߵ��Ǳ������ұߵ��ǳ���
		String b = "a"+c+"b";	//����+����=�������ڱ���ʱ����������䳣���ڴ��������Ǳ����ڴ���
		String a = "a"+c+"b";
		String e = "a"+"b";
		String f = "a"+"b";
		System.out.println(b==c);//false
		System.out.println(e==f);//ture
		Test1 t = new Test1();
	}

	
}
