package com.dj.ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ArrayListTest {
	public static void main(String[] args) {
		Collection c = new ArrayList();   //��������
//		Collection c = new LinkedList();  //��������
		Collection vector = new Vector();
		
		c.add("dj1");
		c.add("dj2");
		c.add("dj3");
		c.add("dj4");
		c.add("dj1");
		c.add("dj3");
		System.out.println(c);
		/*ArrayList list = null;
		if(c instanceof ArrayList){
			list = (ArrayList)c;
		}
		System.out.println(list.get(0));
		
		System.out.println(".............");
		System.out.println(c);
		System.out.println(c.contains("dj1"));
		System.out.println(c.isEmpty());
		System.out.println(c.remove("dj3"));
		System.out.println(c.remove("dj1"));
		System.out.println(c.size());
		
		Object[] o = c.toArray(); //����һ����ʾ���ϵ�����
		System.out.println(Arrays.toString(o));
		
		String[] str = (String[]) c.toArray(new String[c.size()]);
		System.out.println(Arrays.toString(str));*/
		
		System.out.println(".......���ϱ�������...........");
		//����һ�����������Ѽ����е�Ԫ��һ������������
		Iterator it = c.iterator();
		while(it.hasNext()){
			Object o1 = it.next();
			System.out.println(o1);
			it.remove();
		}
		System.out.println(c);
/*		System.out.println("...........................");
		//��ǿforѭ�������ܺܺã����ǲ����Ըı�Ԫ�صĸ���������,ԭ�����޸��쳣��
		for(Object o2:c){
			System.out.println(o2);
		}
		System.out.println("...........................");
		//��ͨforѭ��,����Ƕ��if���
		for(int i=0;i<c.size();i++){
			System.out.println(((ArrayList) c).get(i));
			if(i==5)
				c.add("dj6");
		}
	*/
		System.out.println("............................");
		List<String> list = Arrays.asList("yellow","red","green","blue");
		List<String> list2 = Arrays.asList("yellow","red","green","blue");
		
//		Collections.sort(list, Collections.reverseOrder());
//		Collections.reverse(list);//��������
//		Collections.shuffle(list);//�������ָ�����б�
		Collections.reverseOrder();
//		Collections.shuffle(list, new Random(20));
//		Collections.shuffle(list2, new Random(20));
		System.out.println(list);
//		System.out.println(list2);
//		System.out.println();
		
//		List<Integer> list1 = Arrays.asList(11,21,31,41,51,61,71);
//		System.out.println(Collections.binarySearch(list1, 41));
		
		
	}
}
