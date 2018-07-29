package com.dj.ch13_4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			File file = new File("src/com/dj/ch13_4/a.txt");
			 fis = new FileInputStream(file);
			 in = new ObjectInputStream(fis);
			// ����ķ����л�����һ���������ж�ȡһ������
//			Object o = in.readObject();
//			System.out.println(o);
			Student s = (Student) in.readObject();
			System.out.println(s);
			System.out.println(in.readObject());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
