package jdbc;

import java.sql.Connection;
import java.sql.Statement;

import util.DBUtil;

public class JDBCDemo {
	public static void main(String[] args) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			Statement state=conn.createStatement();
			String sql1="create table icbc_user( "
					   +"  id number(8), "
					   +"  card varchar2(32) primary key, "
					   +"  username varchar2(32), "
					   +"  password varchar2(32), "
					   +"  telephone varchar2(32), "
					   +"  sfnumber varchar2(32), "
					   +"  balance number(10,2)  ) ";
			String sql2="create table user_trecord( "
					   +"  card varchar2(32), "
					   +"  extype varchar2(32), "
					   +"  exmoney number(10,2), "
					   +"  balance number(10,2), "
					   +"  extime date ) ";
			state.execute(sql1);
			state.execute(sql2);
			System.out.println("表1与表2创建完毕！");
			String sql3="create sequence seq_icbcuser_id "
					   +"start with 1000 "
					   +"increment by 1 ";
			state.execute(sql3);
			System.out.println("序列创建成功！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
	}

}

