package com.dj.ch13_3;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
       �Զ����װ�� 
 * */
public class MyReadLine {
	private InputStream in;
	private List<Integer> list;
	public MyReadLine(InputStream in) {
		this.in = in;
		list = new ArrayList<Integer>();
	}
	
	public String readLine() throws IOException{
		list.clear();
		int data = -1;
		byte[] buf = null;
		while((data=in.read())!=-1){
			//���˻س������м����ѳ��س������е�ֵ����list��
			if(data==10){
				break;
			}else if(data!=13){
				list.add(data);
			}
		}
		if(data==-1&&list.size()==0){
			return null;
		}else{
			//��list�����е����ݷ���buf�ֽ�����
			buf = new byte[list.size()];
			for(int i=0;i<list.size();i++){
				int x = list.get(1);
				buf[i] = (byte) x;
			}
		}
		return new String(buf,0,buf.length);
	}
}
