package lx_01;


public class Test_sort {
	
	/**
	 * ð������ֵ��С������������Ķ���(������һ��Ԫ��)ð����������ˮ�е���������һ����ͬʱ��ֵ�ϴ��������
     * ������ĵײ�(�������һ��Ԫ��)����ȥ�������㷨��Ƕ�׵�ѭ������������������α�����ÿ�α�����Ҫ��
     * �����������ڵ�һ��Ԫ�أ�������Ԫ��������(����ֵ���)��˳�����У���ô�������ǵ�λ�ò��䣻�����
     * ��Ԫ���Խ����˳�����У���ô�������ǵ�ֵ��(����Ƚϣ���������ǰ��)
	 * 
	 * */
	public static void bubble_1(){
		int[] num={100,60,80,90,70,30};
		System.out.println("�뿴����ı仯���̣�");
		for(int i=0;i<num.length-1;i++){
			for(int j=0;j<num.length-i-1;j++){
				if(num[j]>num[j+1]){
					int temp = num[j];
					num[j]=num[j+1];
					num[j+1]=temp;					
				}
				System.out.println("i="+i);
				for(int k=0;k<num.length;k++){
					System.out.print(num[k]+"\t");
				}
				System.out.println();
			}
		}
		System.out.println("�����Ľ��Ϊ��");
		for(int k=0;k<num.length;k++){
			System.out.print(num[k]+"\t");
		}
	}
	
	/**Insertion
	 * ��������:
	 *	������̵�ĳһ�м�ʱ�̣�����R�����ֳ�����������R[1����i-1]�����ź��������������
	 *	R[i����n]����ǰδ����Ĳ��֣��ɳ�����������
	 *  ��������Ļ��������ǽ���ǰ�������ĵ�1����¼R[i]���˵�������R[1����i-1]���ʵ���
	 *  λ���ϣ�ʹR[1����i]��Ϊ�µ�����������Ϊ���ַ���ÿ��ʹ����������1����¼��ͨ������������
	 * 	�Ӵ�С����С���󶼿���
	 * 
	 * */
	public static void insert(){
		int[] a = {8,3,7,-2,12,6,22,4};
		System.out.println("����ǰ������:");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		 int key = 0;
/*			//��һ
			for(int j=1;j<a.length;j++){
				int i = 0;
				key = a[j];
				i = j-1;
				while(i>=0&&a[i]>key){
					a[i+1] = a[i];
					i--;
				}
				a[i+1] = key;
			}*/
		
		 for(int i=1;i<a.length;i++){
			 for(int j=0;j<i;j++){
				 if(a[j]<a[i]){
					 int temp = a[j];
					 a[j]=a[i];
					 a[i]=temp;
				 }
			 }
		 }
		 
		System.out.println("--------------��������飺");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	/**ѡ������:
	 * ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������Ȼ����ʣ�µ�����������
	 * ��С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��
	 * */
	public static void select(){
		int[] a = {8,3,7,-2,12,6,22,4};
		System.out.println("����ǰ������:");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		for(int i=0;i<a.length;i++){
			int po= i;//�趨λ�õĳ�ʼֵ
		for(int j=0;j<a.length;j++){
			if(a[po]>a[j]){
				po = j;
			}
			//����λ���趨ֵ����Сֵ���͵�i����λ��
			int temp = a[i];
			a[i] = a[po];
			a[po] = temp;
		}
	}
		
		System.out.println("--------------��������飺");
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
	
	
	public static void main(String[] args) {
		bubble_1();
//		insert();
//		select();
		
	}
	
	
}
