package com.dj.ch09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);

		List<Integer> a1 = new ArrayList<Integer>();
		List<Integer> a2 = new ArrayList<Integer>();
		List a3 = new ArrayList<Integer>();
		//���Ͳ�����ͬ�ķ������Ͳ��ܻ�������, ���������Ͳ�����ļ̳���
//		List<Object> a2 = new ArrayList<Integer>();  false
		
/*		//��֤������ֻ������������������﷨�ģ����е�ʱ����Զ��Ĳ�������
		List list1 ;
		List<Object> olist;
		List<String> slist = new ArrayList<>();
//		olist = slist; //��ƥ��
		list1 = slist;
		olist = list1;*/
		
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("dj", 123);
		
		int result = 0;
/*		for(Object o:list){
			Integer i = (Integer) o;
			result+=i;
		}*/
		//ǿת�Ͼ��з��գ��Ľ�
		for(Integer i:list){
			result+=i;
		}
		System.out.println(result);
	}
}
