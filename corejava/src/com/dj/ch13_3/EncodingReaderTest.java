package com.dj.ch13_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class EncodingReaderTest {
	public static void main(String[] args) {
		//��ʽһ��Ĭ�ϱ��룬���ַ�ʽ���,����Ҫʹ��Ĭ�ϵı���ȥ���ж�д�ַ�
		/*BufferedReader in = null;
		FileReader fr = null;
		try {
			fr = new FileReader("src/com/dj/ch13_3/c.txt");
			in = new BufferedReader(fr);
			String str = in.readLine();
			System.out.println("str="+str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null)fr.close();
				if(in!=null)in.close();
			} catch (IOException e) {
			}
		}*/
		
		//�����ַ�����
		BufferedReader in = null;
		InputStreamReader isr = null;
		InputStream is = null;
		try {
			//����һ���ֽ�������
			is = new FileInputStream("src/com/dj/ch13_3/c.txt");
			//������ֽ�����װ��һ���ַ��� ͬʱ����һ�¶�д�ַ���ʹ�õ��ַ�����
			isr = new InputStreamReader(is,"UTF-8");
//			isr = new InputStreamReader(is,"GBK");
			//������ַ�����װ��һ��BufferedReader����
			in = new BufferedReader(isr);
			String str = in.readLine();
			System.out.println("str="+str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(is!=null)is.close();
				if(isr!=null)isr.close();
				if(in!=null)in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
