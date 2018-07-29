package lx_01;

class Test_fx03 {

	/**
	 * return���ԣ�test1��test2
	 * �ʼǣ�	ע��:return_type:������������˷�������,��ô�ڷ���������ͱ������return���,
	 * 		���ҷ��ص���������Ҫ������һ��,���û�з������͵Ļ�(void),��ô�������������дreturn,
	 * 		Ҳ���Բ�дreturn��������ִ����return���,��ô����Ͳ�����ִ����,ֱ���˳��������������
	 * 
	 * ������finally��Ψһһ��������return����ִ�е����飬
	 * 	           �ų�finally���飬��һ����ֱִ�еĳ����У�return����Ĵ����ǲ��E��ͨ�������
	 * 		��try-catch-finally����У����ǵ�ִ������Ҳ�Ǳ������׵�
	 * 
	 * */
	@SuppressWarnings("finally")
	public static void test1(){
		int a = 0;
		try{
			a = 10;
			System.out.println("���a="+a);
			return;
		}catch(Exception e){
			a=20;
			System.out.println("���a="+a);
			System.out.println(e+".........");
			return;
		}finally {
			a=30;
			System.out.println("���a="+a);
			return;
		}
	}
	
	public static int test2(){
		int a = 0;
		try{
			a = 10;
			System.out.println("���a="+a);
			return a;
		}catch(Exception e){
			a=20;
			System.out.println("���a="+a);
			System.out.println(e+".........");
			return a;
		}finally {
			a=30;
			System.out.println("���a="+a);
//			return a;
		}
//		System.out.println("a="+a);
//		return a;
	}
	
	public static void main(String[] args) {
//		test1();
		test2();
		
		
	}
	
}
