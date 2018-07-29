package com.dj.ch13_1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/**
   InputStream��OutputStream�ǳ����࣬���ֽ����롢������ĸ��࣬���õ��������£�</br>
        ������</br>
         ByteArrayInputStream�� FileInputStream</br>
		 PipedInputStream��ObjectInputStream��StringBufferInputStream</br>
       �����</br>
         ByteArrayOutputStream��FileOutputStream</br>
	     PipedoutputStream��ObjectoutputStream</br>
 * */
public class ByteArrayInputStreamTest {
	public static void main(String[] args) {
		ByteArrayInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			String str = "Hello World...";
			byte[] b = str.getBytes();
		    in = new ByteArrayInputStream(b);
		    out = new ByteArrayOutputStream();
		    
		    byte[] a = new byte[10];
		    int len = in.read(a,0,10);
		    System.out.println(len);
		    
		    out.write(a,0,len);		
		    out.flush();
		    System.out.println(out.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				if(in!=null)in.close();
				if(out!=null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
