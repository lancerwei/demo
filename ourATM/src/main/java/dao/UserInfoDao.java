package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import user.UserInfo;
import util.DBUtil;

public class UserInfoDao {
	//修改表2
	public void modify2(UserInfo userInfo){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update user_trecord "
					  +"set extype=?,exmoney=?,balance=?,extime=? "
					  +"where card=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userInfo.getExtype());
			ps.setDouble(2, userInfo.getExmoney());
			ps.setDouble(3, userInfo.getBalance());
			ps.setDate(4, (Date) userInfo.getExtime());
			ps.setString(5, userInfo.getCard());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	//修改表1
	public void modify(UserInfo userInfo){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="update icbc_user "
					  +"set card=?,username=?,password=?,telephone=?,sfnumber=?,balance=? "
					  +"where card=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userInfo.getCard());
			ps.setString(2, userInfo.getUsername());
			ps.setString(3, userInfo.getPassword());
			ps.setString(4, userInfo.getTelephone());
			ps.setString(5, userInfo.getSfnumber());
			ps.setDouble(6, userInfo.getBalance());
			ps.setInt(7, userInfo.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	//删表2
	public void delete2(String card){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from user_trecord "
					  +"where card=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, card);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	//删表1
	public void delete(String card){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from icbc_user "
					  +"where card=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, card);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	//根据card查表1卡信息
	public UserInfo findByCard1(String card){
		Connection conn=null;
		UserInfo userInfo=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from icbc_user "
					  +"where card=? ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, card);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				userInfo=new UserInfo();
				userInfo.setId(rs.getInt("id"));
				userInfo.setCard(rs.getString("card"));
				userInfo.setUsername(rs.getString("username"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setTelephone(rs.getString("telephone"));
				userInfo.setSfnumber(rs.getString("sfnumber"));
				userInfo.setBalance(rs.getDouble("balance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return userInfo;
	}
	//根据card查表2员工信息
		public UserInfo findById2(String card){
			Connection conn=null;
			UserInfo userInfo=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from user_trecord "
						  +"where card=? ";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, card);
				ResultSet rs=ps.executeQuery();
				if (rs.next()) {
					userInfo=new UserInfo();
					userInfo.setCard(rs.getString("card"));
					userInfo.setExtype(rs.getString("extype"));
					userInfo.setExmoney(rs.getDouble("exmoney"));
					userInfo.setBalance(rs.getDouble("balance"));
					userInfo.setExtime(rs.getDate("extime"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally {
				if (conn!=null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException(e);
					}
				}
			}
			return userInfo;
		}
	//查表1
	public List<UserInfo> findAll1(){
		Connection conn=null;
		List<UserInfo> list=new ArrayList<UserInfo>();
		UserInfo userInfo=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from icbc_user ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				userInfo=new UserInfo();
				userInfo.setId(rs.getInt("id"));
				userInfo.setCard(rs.getString("card"));
				userInfo.setUsername(rs.getString("username"));
				userInfo.setPassword(rs.getString("password"));
				userInfo.setTelephone(rs.getString("telephone"));
				userInfo.setSfnumber(rs.getString("sfnumber"));
				userInfo.setBalance(rs.getDouble("balance"));
				list.add(userInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return list;
	}
	//查表2
	public List<UserInfo> findAll2(){
		Connection conn=null;
		List<UserInfo> list=new ArrayList<UserInfo>();
		UserInfo userInfo=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from user_trecord ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				userInfo=new UserInfo();
				userInfo.setCard(rs.getString("card"));
				userInfo.setExtype(rs.getString("extype"));
				userInfo.setExmoney(rs.getDouble("exmoney"));
				userInfo.setBalance(rs.getDouble("balance"));
				userInfo.setExtime(rs.getDate("extime"));
				list.add(userInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		return list;
	}
	//增表1
	public void save1(UserInfo userInfo){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into icbc_user "
					   +"values "
					   +"(seq_icbcuser_id.nextval,?,?,?,?,?,?) ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userInfo.getCard());
			ps.setString(2, userInfo.getUsername());
			ps.setString(3, userInfo.getPassword());
			ps.setString(4, userInfo.getTelephone());
			ps.setString(5, userInfo.getSfnumber());
			ps.setDouble(6, userInfo.getBalance());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	//增表2
	public void save2(UserInfo userInfo){
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into user_trecord "
					   +"values "
					   +"(?,?,?,?,?) ";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userInfo.getCard());
			ps.setString(2, userInfo.getExtype());
			ps.setDouble(3, userInfo.getExmoney());
			ps.setDouble(4, userInfo.getBalance());
			ps.setDate(5, (Date) userInfo.getExtime());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if (conn!=null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
}
