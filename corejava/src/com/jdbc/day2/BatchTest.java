package com.jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.day1.DBUtil;

public class BatchTest {

	public static void batchState(){
		Connection conn = DBUtil.getConn();
		Statement stm = null;
		try {
			stm = conn.createStatement();
			long start = System.currentTimeMillis();
			System.out.println("¼�����ݿ�ʼ....");
			int temp = 0;
			for(int i=1;i<=1000;i++){
				temp++;
				String sql = "insert into jdbc_user values("+i+",'"+"lisi"+i+"',"+i+")";
				stm.addBatch(sql);
				if(i%100!=0){
					int[] batch = stm.executeBatch();
					System.out.println("��ǰ�ǵ�"+temp+"��¼��"+batch.length+"������");
				}
				System.out.println("һ��������Ϯ..."+i);
			}
			System.out.println("¼�����ݽ���...");
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void batchPrep(){
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "insert into jdbc_user values(?,?,?)";
		
		try {
			pstm = conn.prepareStatement(sql);
			long start = System.currentTimeMillis();
			System.out.println("¼�����ݿ�ʼ...");
			int temp = 0;
			for(int i=1;i<1000;i++){
				temp++;
				pstm.setLong(1, i);
				pstm.setString(2, "lisi"+i);
				pstm.setInt(3, i);
				pstm.addBatch();
				if(i%100!=0){
					int[] batch = pstm.executeBatch();
					System.out.println("��ǰ�ǵ�"+temp+"��¼��"+batch.length+"������");
				}
				System.out.println("һ��������Ϯ...");
			}
			System.out.println("ȫ�����������...");
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BatchTest.batchState();
//		BatchTest.batchPrep();
	}
}
