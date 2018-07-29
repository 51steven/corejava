package com.dj.ch13.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * �ļ�����
 * */
public class FileCopy {
	
	public FileCopy(){
		throw new AssertionError();
	}	

	/**
	 * �ļ�������һ��
	 * @param sourceURL Դ�ļ�·��
	 * @param tragetURL Ŀ���ļ�·��
	 * */
	public static void copyFile(String sourceURL,String tragetURL){
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(sourceURL);
			out = new FileOutputStream(tragetURL);
			byte[] buff = new byte[2048];
			int num = 0;
			if((num=in.read(buff))!=-1){
				out.write(buff, 0, num);
				out.flush();
			}
			System.out.println("�����ɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(in != null)in.close();
				if(out != null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * �ļ�����������
	 * @param sourceURL Դ�ļ�·��
	 * @param tragetURL Ŀ���ļ�·��
	 * �õ�Java 7��TWR��ʹ��TWR����Բ�����finally���ͷ��ⲿ��Դ ���Ӷ��ô���������š�
	 * */
	public static void copyFileNIO(String sourceURL,String tragetURL){
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(sourceURL);
			out = new FileOutputStream(tragetURL);
			FileChannel inChannel = in.getChannel();
			FileChannel outChannel = out.getChannel();
			ByteBuffer buff = ByteBuffer.allocate(2048);
			while(inChannel.read(buff)!=-1){
				buff.flip();
				outChannel.write(buff);
				buff.clear();
			}
			System.out.println("�����ɹ���");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}/*finally{
			try {
				if(in != null)in.close();
				if(out != null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		copyFile("src/com/dj/ch13/test/source.txt", "src/com/dj/ch13/test/traget.txt");
		copyFileNIO("src/com/dj/ch13/test/source.txt", "src/com/dj/ch13/test/traget.txt");
	}

}
