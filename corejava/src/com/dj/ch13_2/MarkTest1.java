package com.dj.ch13_2;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MarkTest1 {
	public static void main(String[] args) {
		InputStream in = null;
		try {
			in = new ByteArrayInputStream("hello world".getBytes());
			/*
			 	һ����δ������ظ��������ݣ�
			 	   1.boolean markSupported()������markSupported()�������ж�������Ƿ�֧���ظ��������ݣ�
			 	            �������true��������������������ñ��
			 	   2.void mark(int readLimit)��Ȼ�����mark(int readLimit)���������ĵ�ǰλ�ÿ�ʼ���ñ�ǣ�
			 	            ��readLimit��Χ����Ч
			 	   3.void reset()��������reset()������ʹ���������¶�λ���ղ����˱�ǵ���ʼλ��         
			 * */
			/*System.out.println(in.markSupported());  //���������ǲ��ǿ��Ա��
			System.out.write(in.read());
			System.out.write(10);
			System.out.write(in.read());
			System.out.write(10);
			System.out.println("...............");
			in.mark(3);				    //�����ĵ�ǰλ�ÿ�ʼ���ñ��
			System.out.write(in.read());
			System.out.write(10);
			System.out.write(in.read());
			System.out.write(10);
			System.out.write(in.read());
			System.out.write(10);
			in.reset();					//ʹ���������¶�λ���ղ����˱�ǵ���ʼλ��
			System.out.println("...........");
			System.out.write(in.read());
			System.out.write(10);*/
			
			//2. hello world
			//104  101	108	108	111	32	119	111	114	108	100	
			int data = -1;
			while((data=in.read())!=-1){
				System.out.print(data+"\t");
				System.out.write(data);
				System.out.println();
				System.out.flush();
				if(data==101){
					in.mark(1);		//�ѱ�Ǳ���101(e)����,�´η������ô�101��һ��(108)��ʼ(��Ϊ101�ڱ��ǰ�Ѿ�������)
				}else if(data==119){
					in.reset();		//resetָ��ָ��111(o),����111�����ڶ������
				}
				Thread.sleep(1000);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			try {
				if(in!=null)in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
