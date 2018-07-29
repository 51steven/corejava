package com.dj.ch07;

public class Student {
	
	private long id;
	private String name;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(long id,String name){
		this.id = id;
		this.name = name;
	}
	//��̬�������-���ò�����-�ж�-ǿת
	@Override
	public boolean equals(Object o) {
		//s3.equals(null):���ж϶������Ƿ�Ϊ�գ������ָ��
		if(o==null){
			return false;
		}
		//s3.equals(new Teacher()):�ж�������ǲ������������
		if(!(o instanceof Student)){
			return false;
		}
		//s3.equals(s3)���ж���������ǲ��ǵ�ǰ�Ķ���������
		if(this ==o){  
			return true;
		}
		Student s = (Student)o;  //ǿת����·���ж��Ƿ����
		if(this.id==s.getId()&&this.name.equals(s.getName())){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "id="+id+",name="+name;
	}
}
