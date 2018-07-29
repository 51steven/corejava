package com.dj.ch13.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class FileUtil {
	// �������еķ������Ǿ�̬��ʽ���ʵ���˽�������˽�в�����������(���Ժ�ϰ��)
	public FileUtil(){
		throw new AssertionError();
	}
	
	/**
     * ͳ�Ƹ����ļ��и����ַ����ĳ��ִ���
     * 
     * @param filename  �ļ���
     * @param word �ַ���
     * @return �ַ������ļ��г��ֵĴ���
     */
    public static int countWordInFile(String filename, String word) {
    	int count = 0;
    	String line = null;
		int index = -1;
		FileReader reader = null;
		BufferedReader br =  null;
    	try {
    		reader = new FileReader(filename);
    		br = new BufferedReader(reader);
    		while((line=br.readLine())!=null){
				while (line.length() >= word.length()&& (index = line.indexOf(word)) >= 0) {
					count++;
					line = line.substring(index + word.length());
				}
    		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(reader!=null)reader.close();
				if(br!=null)br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return count;
    }
    
    /**
     * �г�һ��Ŀ¼�����е��ļ�
     * 
     * @param sourceURL Ŀ¼·��
     * @return �ļ���Ŀ
     * */
    public static void coutFileOfCatalog(String sourceURL){
    	int count = 0;
    	File file = new File(sourceURL);
    	for(File f:file.listFiles()){
    		if(f.isFile()){
    			System.out.println(f.getName());
    			count++;    		}
    	}
    	System.out.println("һ����"+count+"���ļ�");
    }
    
    /**
     * ���ļ��м���չ��
     * 
     * @param file
     * @param level �㼶
     * */
    private static void walkDirectory(File file, int level) {
        if(file.isDirectory()) {
            for(File temp : file.listFiles()) {
            	walkDirectory(temp, level + 1);
            }
        }
        else {
            for(int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(file.getName());
        }
    }
    
	public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
		System.out.println(path.getFileName().toString());
		return FileVisitResult.CONTINUE;
	}
    
    /**
     * ���ļ��м���չ��
     * 
     * @param file
     * */
    public static void showDirectory() {
//    	walkDirectory(new File("src/com/dj/ch13/test/source.txt"), 1);
    	Path path = Paths.get("src/com/dj/ch13/test/source.txt");
    	try {
			Files.walkFileTree(path, new FileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir,
						BasicFileAttributes attrs) throws IOException {
					return null;
				}
				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) throws IOException {
					// TODO Auto-generated method stub
					System.out.println(file.getFileName().toString());
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFileFailed(Path file, IOException exc)
						throws IOException {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc)
						throws IOException {
					// TODO Auto-generated method stub
					return null;
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(countWordInFile("src/com/dj/ch13/test/source.txt","������"));
//		coutFileOfCatalog("src/com/dj/ch13/test");
		showDirectory();
		
		
	}

}
