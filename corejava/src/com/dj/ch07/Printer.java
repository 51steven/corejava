package com.dj.ch07;

 interface Product {
	int getProduceTime();
}

interface Output{
	
	int MAX_CACHE_LINE = 30;
	void out();
	void getData(String msg);
}

public class Printer implements Product,Output{

	private String[] printData = new String[MAX_CACHE_LINE];
	//������¼��ǰ���ӡ��ҳ��
	private int dataNum = 0;
	
	@Override
	public void out() {
		//ֻҪ������ҵ�ͼ�����ӡ
		while(dataNum>0){
			System.out.println("��ӡ"+printData);
			//����ҵ��������ǰ��һλ������ʣ�µ���ҵ����һ
			System.arraycopy(printData, 1, printData, 0, --dataNum);
		}
	}

	@Override
	public void getData(String msg) {
		if(dataNum >= MAX_CACHE_LINE){
			System.out.println("�����������ʧ��");
		}else{
			printData[dataNum++] = msg;
		}
	}

	@Override
	public int getProduceTime() {
		return 40;
	}
	
	public static void main(String[] args) {
		Output o = new Printer();
		o.getData("���");
		o.getData("���ʹ�ýӿ�");
		o.out();
		o.getData("����");
		o.out();
		//����һ��Printer������Product��
		Product p = new Printer();
		System.out.println(p.getProduceTime());
		//���нӿ����͵����ñ���������ֱ�Ӹ�ֵ��Object���͵ı���
		Object obj = p;
	}
}