package com.dj.ch07;

/**
	��Ա�ڲ��ࣺ</br>
		 1���ڴ���ʵ���ڲ����ʵ��ʱ���ⲿ���ʵ�������Ѿ����ڣ�</br>
		 2��ʵ���ڲ����ʵ���Զ������ⲿ���ʵ�������á����ڲ����У� ����ֱ�ӷ����ⲿ������г�Ա��������Ա�����ͳ�Ա������</br>
		 3���ⲿ��ʵ�����ڲ���ʵ��֮����һ�Զ�Ĺ�ϵ��һ���ڲ���ʵ��ֻ������һ���ⲿ��ʵ������һ���ⲿ��ʵ����Ӧ��������ڲ���ʵ����
		         ���ⲿ���в���ֱ�ӷ����ڲ���ĳ�Ա������ͨ���ڲ����ʵ��ȥ���ʡ�</br>
		 4��ʵ���ڲ����в��ܶ��徲̬��Ա����ֻ�ܶ���ʵ����Ա��</br>
		 5�����ʵ���ڲ���B���ⲿ��A����ͬ���ĳ�Ա����ô����B�У� this.v��ʾ��B�ĳ�Ա��A.this.v��ʾ��A�ĳ�Ա��            
* */
public class InstanceOutterClass {
	private String name = "dj";
	private static int age;
	
	//��Ա�ڲ��ࣺ���൱��һ����Ա��������
	//�ڲ��࿪ʼ
	public class InstanceInner{
		private String name = "dj2";
		//��Ա�ڲ��಻���о�̬�����Ի򷽷�
		//private static int age1;
		public void say(String name){
			//������������Ĳ���
			System.out.println("name1="+name);
			//�����ڲ���ĳ�Ա����
			System.out.println("name2="+this.name);
			//�����ⲿ�����ͨ��Ա����(***)
			System.out.println("name3="+InstanceOutterClass.this.name);
			//�����ⲿ��ľ�̬����
			System.out.println("name4="+InstanceOutterClass.age);
			//�����ⲿ��ľ�̬����
			InstanceOutterClass.hello();
			//�����ⲿ�ڵ���ͨ����
			InstanceOutterClass.this.say("nihao");
			InstanceOutterClass.this.new InstanceInner();
		}
	}
	//�ڲ������
	public void say(String name){
		System.out.println(".....");
		this.new InstanceInner();
		init();
		hello();
	}
	public static void hello(){
		System.out.println("123");
//		say();	//���벻ͨ��
//		init(); //���벻ͨ��
		new InstanceOutterClass().say("12345");
	}
	
	//(***)
	public void init(){
		/*�����ڲ������ķ�ʽ����
		 *��ôд��Ҫ�ڵ�ǰ�ⲿ��֮�еķǾ�̬�����вſ���
		 * */
		InstanceInner i = this.new InstanceInner();
		InstanceInner in = new InstanceInner();
		//���ⲿ���з����ڲ�������Ի��߷�������Ҫ�����ڲ���Ķ���
		//�ⲿ���з����ڲ���ķ���
		i.say("dj");
		//�ⲿ���з����ڲ��������
		System.out.println(i.name);
	}
	public static void main(String[] args) {
		//�����ڲ������ķ�ʽһ����***��̬�����У�
		InstanceOutterClass.InstanceInner ii = new InstanceOutterClass().new InstanceInner();
		InstanceInner ii2 = new InstanceOutterClass().new InstanceInner();
		//�����ڲ������ʽ����(�ȴ����ⲿ����������ⲿ�����)
		InstanceOutterClass ioc = new InstanceOutterClass();
		InstanceInner ii3 = ioc.new InstanceInner();
		ii3.say("dj");
	}
	
}
