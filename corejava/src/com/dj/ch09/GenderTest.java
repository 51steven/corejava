package com.dj.ch09;

public class GenderTest {
	public static void main(String[] args) {
		Gender g1 = Gender.B;
		Gender g2 = Gender.G;
		
		g1.setName("bo");
		g1.test();
		
		g2.setName("girl");
		g2.test();
		
		GenderTest ge = new GenderTest();
		
/*		//��д�Ķ���̫���ˣ�ʲôString������������ţ��Ǿͻ��кö����Ա���
 * 		ge.run("nan");
		ge.run("nv");
		ge.run("....");
		*/
		ge.run(Gender.B);
		ge.run(Gender.B);
	}
/*	public void run(String string){
		
	}*/
	public void run(Gender gender){
		
	}
	
}
