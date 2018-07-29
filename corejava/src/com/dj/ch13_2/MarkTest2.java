package com.dj.ch13_2;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkTest2 {
	public static void main(String[] args) {
		
		InputStream in = null;
		 //InputStream�ķ�װ��
		 //BufferedInputStream�า���˱����˵��������Ķ�������Ϊ�����û���������߶����ݵ�Ч��
		BufferedInputStream bis = null;
		
		try {
			in = new ByteArrayInputStream("hello world".getBytes()); 
			//BufferedInputStream��Ƕ����һ��ByteArrayInputStream���������Ļ�������СΪ5���ֽ�
			bis = new BufferedInputStream(in,5);
			
			System.out.println(bis.markSupported());
			System.out.println("---------------------");
			
			//hello world
			//104  101	108	108	111	32	119	111	114	108	100	
			//51(�������Ĵ�С=5����ǵ���Ч��Χ=1)  �ɹ���������>�����||reset�ڱ����֮��
			//54(..........5............=5)  �ɹ�...........||.............��
			//15(.........=1,...........=5)  �ɹ�:������<�����||.............��
			//11(..........1.............1)	  ʧ��:������<�����&&reset�ڱ����֮��
			//�ܽ᣺������������һ���ͺ���
			int data = -1;
			while((data=bis.read())!=-1){
				System.out.write(data);
				System.out.flush();
				if(data==101){
					bis.mark(5);		
				}else if(data==111){
					bis.reset();		
				}
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(in!=null)in.close();
				if(bis!=null)bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
