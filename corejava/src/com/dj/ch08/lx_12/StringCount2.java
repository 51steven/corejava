package com.dj.ch08.lx_12;

import java.util.Set;
import java.util.TreeSet;

public class StringCount2 {

	private String str = "";
	private Set<String> treeSet = new TreeSet<String>();
	
	public void toRepeat(String str){
		for(int i=0;i<str.length();i++){
			/*treeSet����ȥ�ص��ص㣬�����������
			 * str.charAt(i)ȡ���������ַ��ͣ���Ҫ+""��ʹ�����String����
			 * */
			treeSet.add(""+str.charAt(i));
		}
	}
	public String newString(){
		for(String a:treeSet){
			str=str+a;
		}
		return str;
	}
	public static void main(String[] args) {
		StringCount2 count = new StringCount2();
		String str = "wwqweqdasdafdsfdsferer";
		count.toRepeat(str);
		System.out.println(count.newString());
	}
}
