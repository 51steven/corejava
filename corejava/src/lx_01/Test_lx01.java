package lx_01;

import java.util.Scanner;

public class Test_lx01 {

	/**
	 * 쳲��������У�
	 * 0 1 1 2 3 5 8 13 21
	 * 
	 * */
	public static void test1(){
		Scanner input = new Scanner(System.in);
		System.out.println("�����������ܹ��ж��ٸ�����");
		int n = input.nextInt();
		long[] num = new long[n];
		num[0]=0;
		if(n>0)num[1]=1;
		for(int i=2;i<n;i++){
			num[i]=num[i-1]+num[i-2];
		}
		System.out.println("����Ϊ��");
		for(int j=0;j<n;j++){
			System.out.print(num[j]+" ");
		}
	}
	
	/**
	 * ��Ŀ����1��2��3��4�����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�(���У�24,&& ��if��for)
	 * ��������������ڰ�λ��ʮλ����λ�����ֶ�������1��2��3��4��������е����к���ȥ�����������������С�
	 * 
	 * */
	public static void test2(){
		int num;
		int count = 0;
		for(int i=1;i<=4;i++){
			for(int j=1;j<=4;j++){
				for(int k=1;k<=4;k++){
					if(i!=j&i!=k&j!=k){
						num = i*100+j*10+k;
						count++;
						//continu;
						System.out.print(num+"\t");
					}
				}
			}
		}
		System.out.println();
		System.out.println("��"+count+"��������������λ��");
	}
	
	/**
	 * 3,��ӡ�����еġ�ˮ�ɻ���������ν��ˮ�ɻ�������ָһ����λ�������λ���������͵��ڸ�������
	 * ���磺153��һ����ˮ�ɻ���������Ϊ153=1�����η���5�����η���3�����η���
	 * 	������Ϊˮ�ɻ���:
			 153 370 371 407
	 * /��%�����ã��ø�������һ��
	 * */
	public static void test3(){
		 System.out.println("������Ϊˮ�ɻ���:");
		    for(int i=100;i<1000;i++){
		      int a=i/100;//��ʾ��λ������
		      int b=i/10%10;//��ʾʮλ������
		      int c=i%10;//��ʾ��λ����;
		      if(i==Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)){
		      System.out.print(" "+i);
		    }
		 }
	}
	/**
	 * ��1000���ڵ���ȫ��
	 * ��һ����Ȼ����ǡ�����ȥ�����������һ�������ĺ���ȣ�������������ȫ����
	 * */
	public static void test4(){
		System.out.println("1~1000���ڵ���ȫ����:");
		  for(int i=1;i<=1000;i++){
		     int sum=0;
		     for(int j=1;j<=i/2;j++){
		      if(i%j==0){
		       sum+=j;
		     }
		     }
		    if(sum==i){
		     System.out.print(" "+i);
		     }
		  }
	}
	
	/**
	 * �Զ�������ʽ���һ��ʮ����������forѭ������λ�Լ�&����
	 * */
	public static void test5(){
		//��һ:ԭ�������������ʽ��ʮ���ƻ��ɶ����ƵĹ���
		Scanner input  = new Scanner(System.in);
		System.out.println("����һ��ʮ������������");
		int num = input.nextInt();
		
		/*int i = 1;
		int[] b = new int[8];
		int a;
		a = num;	
		while(a!=0){
			b[i] = a%2; //��2���࣬��������1����0,Ҳ������Ӧ�Ķ�����λ
			a = a/2;   //��2ȡ����ͨ���ж������Ƿ�Ϊ0������ѭ��
			i++;
		}
		for(i=7;i>=0;i--){		
		System.out.print(b[i]);
		}*/
		
		/*//��������ʦ�ķ�����ִ��ʱ��������(�����ִ�У�IDE������һ��runҲ����)��32λ������λ��1ͨ��j��forѭ��
		   System.out.print(num+"��2������Ϊ:");
		     int j;
		    for(j=31;j>=0;j--){		//intΪ32λ
			 if((1<<j&num)==0){		//1����31λ���λ��a&���㣬�Ӹ�λ��ʼ���.1<<31Ϊ����
			 System.out.print("0");
			 }else{
			 System.out.print("1");
			 }
		 }
		   System.out.println("");*/
		

		//����:int--32��������λ������32λ�Ķ�����λ&���㣬������������λ����������ת��Ϊ�ַ����ķ�ʽ���
		String str = "";
		for(int a=12;a>0;a=a>>1){
			str = (a&1)+str;   //1Ĭ��Ϊint��
		}
		System.out.println(str);
		
		
	}
	
	/**
	 * �ж�101-200֮���ж��ٸ����������������������
	 * (if[] if(&&))ֻ�ܱ�1����������������Ȼ��Ϊ����(����)
	*/
	public static void test6(){
		int count = 0;
		//��һ����ʦ�𰸣��ų�1,ȥ��ֻ�������Լ�����
		for(int i = 101;i < 200;i+= 2){
			for(int j=2;j<=i;j++){
				if(i%j==0&&i!=j){ //�����ˣ����ǲ��ǳ��Լ����Ͳ���������������ѭ��
					break;
				}else if(i%j==0){	//�����ˣ����Լ���ֻ�������Լ����������������
					System.out.print(i+" ");
					count++;
				}
		      }
		}
	
	/*
		//����:�ų�1�ͱ���ȥ��û��������i
		for(int i=101;i<200;i+=2){		//1=101,i+=2,�ų�ż����ǿ�㷨����
			for(int j=2;j<i;j++){		//ͨ��forѭ���ų�1��������
					if(i%j==0){		//���ܹ�������������ѭ��
						break;	
					}else if(j==i-1){ //�������������������ͨ��j==i-1�ж�ѭ���Ƿ���е���
						System.out.print(i+" ");
						count++;	
				}
			}
		}
	*/
	     System.out.println("\n" + "Total "+ count + " prime number between 101 and 200");
	}
	
	/**
	 * �������������Լ������С������
	 * */
	public static void test7(){
		Scanner input = new Scanner(System.in);
		System.out.println("�������̨����һ������");
		int a = input.nextInt();
		System.out.println("�ٴ������̨����һ������");
		int b = input.nextInt();
		int pro=a*b;
		   int t=0;
		   if(a<b){
		   t=a;
		   a=b;
		   b=t;
		   } 
		   while(b!=0){
		    t=a%b;
		    a=b;
		    b=t;
		  }
		  System.out.println("�����������Լ��Ϊ:"+a);
		  System.out.println("����������С������Ϊ:"+pro/a);
	}
	
	public static void main(String[] args) {
//		test1();
//		test2();
//		test3();
//		test4();
//		test5();
//		test6();
//		test7();
	}
	
}
