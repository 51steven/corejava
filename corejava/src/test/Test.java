package test;

public class Test {
	
	public static void print(){
		// ����һЩ������������ʽ�������  
        double d = 345.678;  
        String s = "��ã�";  
        int i = 1234;  
        // "%"��ʾ���и�ʽ�������"%"֮�������Ϊ��ʽ�Ķ��塣 
        // "f"��ʾ��ʽ������������� 
//        System.out.printf("%f", d); //345.678000
//        System.out.println();  
        // "9.2"�е�9��ʾ����ĳ��ȣ�2��ʾС������λ���� ע���������ǰ��Ŀո� 
        System.out.printf("%1.2f", d);//   345.68
        System.out.println();  
        // "+"��ʾ��������������š�  
        /*  System.out.printf("%+9.2f", d);//  +345.68
        System.out.println();  
        // "-"��ʾ�����������루Ĭ��Ϊ�Ҷ��룩��  
        System.out.printf("%-9.4f", d);//345.6780
        System.out.println();  
        // "+-"��ʾ���������������������롣  
        System.out.printf("%+-9.3f", d);//+345.678
        System.out.println();  
        // "d"��ʾ���ʮ����������
        System.out.printf("%d", i);//1234
        System.out.println();  
        // "o"��ʾ����˽��������� 
        System.out.printf("%o", i);//2322
        System.out.println();  
        // "x"��ʾ���ʮ������������  
        System.out.printf("%x", i);//4d2
        System.out.println();  
        // "#x"��ʾ�������ʮ�����Ʊ�־��������  
        System.out.printf("%#x", i);//0x4d2
        System.out.println();  
        // "s"��ʾ����ַ�����
        System.out.printf("%s", s);//��ã� 
        System.out.println();  
        System.out.printf("���һ����������%f��һ��������%d��һ���ַ�����%s", d, i, s);
        //���һ����������345.678000��һ��������1234��һ���ַ�������ã�
*/       

		
	}
	
	public static void sortPrint(int[] num){
		for(int i=0;i<num.length;i++)
			System.out.print(num[i] + "\t");
	}
	public static void sortBubble(int[] num){
		for(int	i=0;i<num.length-1;i++){
			for(int j=1;j<num.length-1-1;j++){
				if(num[j]>num[j+1]){
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
			System.out.println("i="+i);
			sortPrint(num);
			System.out.println();
		}
	
	}
	public static void arrayMax(int[] num){
		int result = num[0];
		for(int i=1;i<num.length;i++){
			if(result<num[i])
				result = num[i];
		} 
		System.out.println("result="+result);
	}
	public static void arrayAvg(int[] num){
		double result = 0;
		for(int i=0;i<num.length;i++){
			result +=num[i]; 
		}
		result /= num.length;
		System.out.println("result="+result);
	}
	public static void arrayTest(){
		//1.
		int array[];
		int []arr = {1,2,3};
		int length = arr.length;
		int i = arr[1];
		//2.
		String[][] roon = new String[2][3];
		roon[0] = new String[]{"",null,"1"};
		roon[1] = new String[]{"",null,"2"};
		String[][] roon1 = {
				{"",null,"1"},
				{"",null,"2"}
		};
		
		int[] num = {20,40,30,70,10}; 
		//3.avg
//		arrayAvg(num);
		//4.max
//		arrayMax(num);
		//5.bulle sort
//		sortBubble(num);
/*		sortPrint(num);
		System.out.println();
		Arrays.sort(num);
		sortPrint(num);
		System.out.println();*/
//		System.out.println(Arrays.toString(num));
		
	}
	public static void main(String[] args) {
		arrayTest();
		print();
		
	}
}
