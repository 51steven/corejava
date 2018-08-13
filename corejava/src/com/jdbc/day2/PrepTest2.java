package com.jdbc.day2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.day1.DBUtil;

public class PrepTest2 {
	public static void main(String[] args) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstm = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			String sql = "insert into jdbc_user values(?,?,?)";
			pstm = conn.prepareStatement(sql);
			//���ݿ�Ԫ����
//			DatabaseMetaData metaData = conn.getMetaData();
			for(int i=5;i<10;i++){
				pstm.setLong(1, i);
				pstm.setString(2, "hqr"+i);
				pstm.setInt(3, 2+i);
				pstm.executeUpdate();
			}
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from jdbc_user");
			//�����Ԫ����
			ResultSetMetaData meta = rs.getMetaData();
//			System.out.println("��ѯ���ݵ�����:"+meta.getColumnCount());
			for(int i=1;i<=meta.getColumnCount();i++){
				System.out.println("��ѯ���ݵ�����Ϊ:"+meta.getColumnName(i));
				System.out.println(meta.getColumnType(i));
				rs.next();
				System.out.println(meta.getColumnTypeName(i));
				if("number".equalsIgnoreCase(meta.getColumnTypeName(i))){
					System.out.println(rs.getLong(i));
				}
				System.out.println("------------");
			}
			while(rs.next()){
				System.out.println("IDΪ:"+rs.getLong(1));
				System.out.println("nameΪ:"+rs.getString(2));
				System.out.println("ageΪ:"+rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stm!=null)stm.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
