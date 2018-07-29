package com.dj.ch11_2;

//�¼�Դ (�൱�������е�Ů��)
public class EmotionSource {
	private String name;
	private EmotionListenner boy;
	
	//�����ж�����������¼�Դ���м���
	//��ʱ����Ҫ��ÿһ�����������ŵ���������
	//private List<EmotionListenner> boys;
	
	
	//�ڵ�ǰ�¼�Դ����ע�������
	public void addActionListenner(EmotionListenner listenner){
		this.boy = listenner;
	}
	
	//�Ƴ���ǰ�¼�Դ����ļ�����
	public void removeActionListenner(){
		this.boy = null;
	}
	
	public EmotionSource() {
		this("girl");
	}
	public EmotionSource(String name) {
		this.name = name;
	}
	public void happy(){
		System.out.println("I am so Happy and I will tall the boy");
		
		//���¼�Դ�ڲ������¼�����  e
		EmotionEvent e = new EmotionEvent(this);
		//Ȼ��Ѳ������¼�(�¼�����e)֪ͨ��������
		boy.happy(e);
	}
	
	public void sad(){
		System.out.println("I am so sad and I will tall the boy");
		
		//���¼�Դ�ڲ������¼�����  e
		EmotionEvent e = new EmotionEvent(this);
		//Ȼ��Ѳ������¼�(�¼�����e)֪ͨ��������
		boy.sad(e);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
