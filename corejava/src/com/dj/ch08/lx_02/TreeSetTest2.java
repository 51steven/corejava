package com.dj.ch08.lx_02;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest2 {
	public static void main(String[] args) {
		Set<Integer> s = new TreeSet<Integer>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				/*ǰ������if�ж�������ǰż�ں��桢ż˭��˭С��˵����
				 * TreeSet�㷨�� 1 3 5 7 ��С��������
				 * �����else����������
				 * ���ֵıȽ�������
				 * */
				//o1Ϊ������o2Ϊż��������ifȷ����������ǰ��
				if(o1%2==1&&o2%2==0){
					return -1;			//O1(����)����O2(ż��)Ϊ����o1С����ǰ��	
				}
				//O1Ϊż����O2Ϊ����	
				if(o1%2==0&&o2%2==1){  
					return 1;			//O1(ż��)����O2(����)Ϊ����o1�����ں���
				}
				if(o1%2==0&&o2%2==0){ 
					return -(o1-o2);
				}
				if(o1%2==1&&o2%2==1){
					return o1-o2;
				}
				else{					//�ж�С��������ǰ��,ͨ��-����������ż��������
					return -o1+o2;
				}
			}
		});
		s.add(10);
		s.add(8);
		s.add(2);
		s.add(1);
		s.add(7);
		s.add(6);
		s.add(3);
		s.add(5);
		s.add(4);
		s.add(9);
		
		for(Object o:s){
			System.out.println(o);
		}
	}
}
