package com.dj.ch13_1;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {
	public static void main(String[] args) {
		//������
		InputStream in = System.in;   //����̨����
		try {
		    //InputStream������read()���ط���
		   /* 
		    1����������д���ݣ�read()
			      һ�ζ�һ���ֽڣ��������ֽڵ�ֵ��Ҫ�������ݣ����ȵ��ж������ݰ��������Ի��и��߳�����Ч��
			     �ڿ���̨����1Ȼ��س�������̨����49��13��10�ֱ��Ǽ�����1���س������е�ASCII��ֵ
		    */ 	         
			int data = in.read();  
			//�õ����ݺ���ж�Ӧ�Ĵ������ݲ���
			while(data!=32){
				data = in.read();
				System.out.println(data);
			}
			
			//2��read(byte[] b);
			/*byte[] b = new byte[5];
			int len = in.read(b);
			//����a,��ӡ3(a���س�������һ�������ֽ�)������12345����ӡ5(����ĳ���Ϊ5��ֻ�ܴ���ô��)
			System.out.println(len);  
			System.out.println("..............");
			for(byte data:b){
				System.out.println(data);
			}
			System.out.println("..................");
			//���ֽ�ת���ַ���,2λ�س�(13)+����(10),����ո�(32)
			//�����еĲ������ն������ֽ������ʽ�����ϵͳ����ָ��
			String str = new String(b, 0, len-2); 	
			System.out.println(str);*/
			
			//3��read(byte[] b, int off,int len);
			/*byte[] b = new byte[5];
			int len = in.read(b, 1, b.length-1);
			System.out.println(len);
			System.out.println(".................");
			for(byte data:b){
				System.out.println(data);
			}*/
				
			//4��	
			/*byte[] b = new byte[10];
			int len = in.read(b);
			while(len!=-1){
				//ȥ���س���������ռ����ĳ���
				if(b[len-1]==10&&b[len-2]==13) len = len-2;   
				String s = new String(b, 0, len);
				System.out.println(s);
				len = in.read(b);
			}*/
			
			//5���Զ���ģ������	
			/*byte[] b = new byte[10];
			int len = -1;
			while((len=in.read(b))!=-1){       //-1,�������ļ���ĩβ
				if(b[len-1]==10&&b[len-2]==13) len = len-2;   //ȥ�������س��������ַ������鳤��
				String s = new String(b, 0, len);
				if("bye".equals(s))break;
				if("ls".equals(s)){
					System.out.println(" a.txt "+" b.txt "+" c.zip "+" Hello.java ");
				}else{
					System.out.println(s);
				}
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//�ر���
				if(in!=null)in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
