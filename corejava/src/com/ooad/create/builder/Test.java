package com.ooad.create.builder;

/*5.������ģʽ(Builder)
 *��һ�����Ӷ���Ĺ��������ı�ʾ����
 * */
public class Test{
    
    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();
        Person person = pd.constructPerson(new ManBuilder());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());
        System.out.println(person.getHead());
    }
}

