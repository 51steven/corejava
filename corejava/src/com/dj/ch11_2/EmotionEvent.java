package com.dj.ch11_2;

//�¼�������  (�൱��������Ů����������Щ���� ������ˡ����ˡ����ˡ����ĵ��¼�)(�¼�Դ������)
public class EmotionEvent {
	//�¼���������Ҫ���¼�Դ����(˭��������¼�����)
	private Object source;
	private String desc;
	
	
	public EmotionEvent(Object source) {
		this.source = source;
	}
	public EmotionEvent(Object source, String desc) {
		this.source = source;
		this.desc = desc;
	}
	public Object getSource() {
		return source;
	}
	public void setSource(Object source) {
		this.source = source;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
