package com.dj.ch09;

//��ö�����Ϳ���һ���������������

public enum Gender implements So{
	B("��") {
		@Override
		public void go() {
			// TODO Auto-generated method stub
		}
	}
	,G ("Ů"){
		@Override
		public void go() {
			// TODO Auto-generated method stub
		}
	};
//------�̶�����������--------------------
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	private  Gender() {
		//��ӡ���Σ��м���Ԫ�ؾͼ���
		System.out.println("�޲ι��캯��");
		// TODO Auto-generated constructor stub
	}
	private Gender(String name){
		this.name = name;
	}
	@Override
	public void test() {
		
	}
	public abstract void go();
}

interface So{
	void test();
}
