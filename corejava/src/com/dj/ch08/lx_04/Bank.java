package com.dj.ch08.lx_04;

import java.util.HashMap;

//����
public class Bank {
	private HashMap customers;  //�˿�
	private int custNum;	//�˿���
	
	public Bank(){
		customers = new HashMap();
	    custNum++;
	}
	public void addCustomer(Customer customer){
		customers.put(new Integer(custNum+1), customer);
		custNum ++;
	}
	
	public Customer getCustomer(int index){
		if(index>0 && index<=custNum)
			return (Customer)(customers.get(new Integer(index)));
		else
			return null;
	}

	public HashMap getAllCustomer(){
		return customers;
	}
	public int getCustomerNum(){
		return custNum;
	}
}
