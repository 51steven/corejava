package com.jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FirstJDBC {
	
	public static void main(String[] args) {
		//"jdbc����:����:��Э�飺@��ַ���˿ڣ����ݿ�汾(xe:oracle�򻯰�,orcl������)"
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "dj";
		String password = "dj";
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		PreparedStatement pstm = null;
		
		try {
			//1��ע������(oracle����) 
			/*OracleDriver:ojdbc14.jar�е�һ����,��һ������jdbcʹ�ã����ɳ���Աʹ��;
			 * ����ĳ�������ȷʹ�����е�ĳ����ʱ���ᱻJVM�Զ�����;
			 * �����ڳ����в���ʾ��ʹ������������,��ˣ������д�������JVM��������
			 * */
			Class.forName("oracle.jdbc.OracleDriver");
			//2���������ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			//3���������
			//Ԥ����
/*			pstm = conn.prepareStatement("insert into s_region(id,name) values(?,?)");
			for(int i=25;i<30;i++){
				pstm.setLong(1,100+i);
				pstm.setString(2, "����"+121);
				pstm.executeUpdate(); 
			}*/
			stm = conn.createStatement();
			//4��ִ�����
			String sql = "select id,name from s_region";
			rs = stm.executeQuery(sql);
			stm.execute(sql);
			stm.execute("insert into s_region values(11,'�й�')");
//			stm.executeUpdate("create table temp1(col1 number(12),clo2 varchar2(20))");
			//5����������
			while(rs.next()){
				System.out.println("IDΪ:"+rs.getLong(1));
				System.out.println("����Ϊ:"+rs.getString(2));
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//6���ر�JDBC����(˳������)
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
