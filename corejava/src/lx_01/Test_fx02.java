package lx_01;

public class Test_fx02 {
	
	//1������ĳ��ȿ���Ϊ0����ʱ������һ��Ԫ��Ҳû�С�
	public static void test1(){
		int[] i = new int[0];
		System.out.println(i.length);
//		System.out.println(i[0]); //�������쳣�������±�Խ��ArrayIndexOfBoundsException
		System.out.println(i);
	}
	public static void test2(){
		//ò������������ĳ���
		int[] x = new int[3];
		int[] y = x;
		x = new int[12];
		
		//�������������������ʼ��
		int[] n = {1,2,3};
		int[] m = new int[]{1,2,2};
		Student[] s = new Student[]{new Student(),new Student("sdf", 12, "male")};
		Student[] s1 = {new Student(),new Student("sdf", 12, "male")};
		
	}
	public static void main(String[] args) {
//		test1();


		
		
		
		
	}
	
}
class Student{
	private String name;
	private int age;
	private String gender;
	public Student(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Student() {
	}
}

