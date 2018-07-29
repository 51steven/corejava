package com.dj.ch08.lx_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StringCount {
	public static void main(String[] args) {
		
		String str = "dsfasdgfasdfafdsdfasdf";
		
		//����һ��ArrayListʵ��
		ArrayList data = new ArrayList();  //Listȷ��˳��Ĳ��䣬data�������ȥ�غ������
		for(int i=0;i<str.length();i++){
			String s = str.substring(i,i+1);	//����i�� i+1-1���ַ�
			if(!data.contains(s)){		//������û�����Ԫ�ؾ����
				data.add(s);
			}
		}
		for(Object o:data){
			System.out.println(o);
		}
		System.out.println("..............");
		
		//��������HashMap
		Map<String, Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<str.length();i++){
			String s = str.substring(i,i+1);
			if(!map.containsKey(s)){
				map.put(s, 1);
			}else{
				map.put(s, map.get(s)+1);  //��ͬ���ĸ���+1��ȥ�ز��Ҽ����ظ���ĸ�ĸ���
			}
		}
		
		Set entrySet = map.entrySet();
		Iterator it = entrySet.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
