package com.dj.ch08.lx_02;

public class Test {
	public static void a(String str){
		 str = "nihao";
	}
	public static String b(String str){
		return str = "nihao";
	}
	public static void main(String[] args) {
		String str = "hello";
		a(str);	
		System.out.println(str); 	//hello
		System.out.println(b(str)); //nihao
	}
}
//���hello
/*String ������ڴ��ڷ������������
 * ��JVM��main()�����е�String ----hello,�����ڴ�ռ���hello������ı䣬������ַָ��str
 *������� ��̬����a(),��str��ֵ��ʱ��JVM��ѡ�nihao���ͷ������е�����ƥ�䣬���û�ҵ���nihao��������ݣ�
 *�͸���nihao������һ���µ��ڴ��ţ�����ҵ��ˣ��Ͱѡ�nihao���ĵ�ַָ���µ�����
 * */
