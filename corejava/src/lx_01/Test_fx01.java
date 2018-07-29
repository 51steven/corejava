package lx_01;

import java.util.Scanner;

public class Test_fx01 {
	
	/**
	 * ֪ʶ��һ: switch ��֧���
	 *a. expr�����ͱ�����byte, short, char����int;������Ϊboolean
     *b. valuesN���ͱ�����byte, short, char����int, ��ֵ�����ǳ���������case�Ӿ��valueNֵ��ͬ��
     *c. ��switch���ʽ��ֵ�����κ�case�Ӿ�ƥ��ʱ������ִ��default�Ӿ䣬����û��default�Ӿ䣬�����ֱ���˳�switch��䡣
     *default�Ӿ����λ��switch����е��κ�λ�á�
     *d. ���switch���ʽ��ĳ��case���ʽƥ�䣬������default���ƥ�䣬�ʹ����case�Ӿ��default�Ӿ俪ʼִ�С�
     *��������break�����˳�����switch��䣬��������ִ��switch����к�����case�Ӿ䣬���ټ��case���ʽ��ֵ��
     *e. switch���Ĺ���Ҳ������if...else�����ʵ�֡���switch����ʹ�������࣬�ɶ��Ը�ǿ����if...else���ܸ�Ϊǿ��
	 * */
	//1�� дһ����������ʵ����ֵ���ں��������ڵ�ת������0��ת��Ϊ������, 1��ת��Ϊ����һ��
	public static void test1(){
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("������һ��0~6������:"+"\n");
			int num = input.nextInt();
			if(num==7)break;
			switch (num) {
			case 0:
				System.out.println("������������"+"\n");
				break;
			case 1:
				System.out.println("����������һ"+"\n");
				break;
			case 2:
				System.out.println("���������ڶ�"+"\n");
				break;
			case 3:
				System.out.println("������������"+"\n");
				break;
			case 4:
				System.out.println("������������"+"\n");
				break;
			case 5:
				System.out.println("������������"+"\n");
				break;
			default:
				System.out.println("������������"+"\n");
				break;
			}
		}
	}
	
    //2�� дһ������������ָ���·����һ�쵽���Ƕ��ٺţ�
	public static void test2(){
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.println("������һ��1~12������:"+"\n");
			int num = input.nextInt();
			if(num==0)break;
			switch (num) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("�������һ����31��");
				break;
			case 2:
				System.out.println("�������һ����28��");
				break;
			case 4:
				System.out.println("�������һ����30��");
				break;
			default:
				break;
			}
		}
	}
	
	/**
	 * ֪ʶ���������ѭ��
	 *  break: ��ֹ��ǰ��ָ��ѭ����
	 *  continue: ��������ѭ����ִ����һ��ѭ������ִ�б�ű�ʶ��ѭ���塣
	 *  label: ���������ʶ�����е���䣬��ŵ����ֿ���������ĺϷ���ʶ����
	 * */
	//3��break
	public static void test3(){
		int sum = 0;
		int i=0;
		while(sum<20){
			i++;
			sum+=i;
			if(i==5)break;
		}
		System.out.println(sum+"...................");
		while(true){
			int result=0;
			for(int j=0;j<20;j++){
				System.out.println(j+"....break");
				if(j%2==0)break;
			}
		}
	}
	
	//contiue
	public static void test4(){
		// ʵ��ָ����Χ�������ĺͣ�
			int result=0;
			for(int k=0;k<10;k++){
				if(k%2==0)continue;
				result+=k;
				System.out.println(result+"....continue");
			}
	}
	
	//label:�۲�����Ч����ʲô��ͬ:
	public static void test5_1(){
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println(".........");
	}
	public static void test5_2(){
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(j);
				if(j==3){
					break;
				}
			}
			System.out.println();
		}
		System.out.println("........");
	}
	public static void test5_3(){
		f1:for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				System.out.print(j);
				if(j==3){
					break f1;
				}
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
		
/*		test5_1();
		test5_2();
		test5_3();*/
		
	}
}
