package com.dj.ch07;

public interface InterfaceA {
	int AGE = 20; 	//��д��JVM��Ĭ�ϸ�����������Ĺؼ���
	public static final int BGE = 30; 	//��ʾ����public static final����
	
	void say();//���󷽷��ļ�д��Ĭ�����η�Ϊ public abstract
	//public abstract void say();
	
}

 interface InterfaceB{
	String NAME = "tom";
	int go(String dj);
}

//�ӿ���ӿ�֮���Ƕ�̳�
//�����֮���ǵ��̳�
interface InterfaceC extends InterfaceA,InterfaceB{ 
	
}

interface InterfaceD{
	
}
//ctrl+1
//��ͽӿ�֮���Ƕ�ʵ�֣�һ�������ʵ�ֶ���ӿ�
class InterfaceImpl implements InterfaceC,InterfaceD{  
	@Override
	public void say() {
		// TODO Auto-generated method stub
	}
	@Override
	public int go(String dj) {
		// TODO Auto-generated method stub
		return 0;
	}
}

   class InterfaceTest{
	   
	public static void main(String[] args) {
		System.out.println(InterfaceA.AGE);
		System.out.println(InterfaceA.BGE);
		InterfaceA a = new InterfaceImpl();
		a.say();
		InterfaceB b = new InterfaceImpl();
		b.go("");
		InterfaceC c = new InterfaceImpl();
		c.go("");
		c.say();
		InterfaceD d = new InterfaceImpl();
		//��̬������ԣ����ò�����ǿתһ���ٵ��ã�ǿתǰ���ж�һ�£�
		if(d instanceof InterfaceImpl){		
			InterfaceImpl i = (InterfaceImpl)d;
			i.say();
			i.go("");
		}
	}
}
class Test{
	
	public void say(){
		
	}
}
   
abstract class abTest{
	
	public abstract void  test();
}

abstract class abTest1 extends abTest{
	
	public abstract void  test();
} 

abstract class abTest2 extends Test{
	
	public abstract void  test();
} 




