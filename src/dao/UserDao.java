package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import po.User;
import util.DBUtil;

/**
 * user连接数据库
 * @author 汪wqs
 *
 * 2019年10月28日 下午4:05:48
 * 2019年11月12日
 */

public class UserDao {
	
	// 添加 ---- 注册
	public int addUser(User user) {
		Connection conn = DBUtil.getConn();
		String sql = "insert into user(stuid, name, password, phone, flag) values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getStuid());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getPhone());
			pstmt.setInt(5, user.getFlag());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
	
	// 根据学号和密码查询 ---- 登录
	public User findByStuidAndPwd(String stuid, String password) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from user where stuid=? and password=?";
		PreparedStatement pstmt = null;
		User user = null;
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stuid);
			pstmt.setString(2, password);
			
			rSet = pstmt.executeQuery();
			while(rSet.next()) {
				user = new User();
				user.setId(rSet.getInt(1));
				user.setStuid(rSet.getString(2));
				user.setName(rSet.getString(3));
				user.setPassword(rSet.getString(4));
				user.setPhone(rSet.getString(5));
				user.setFlag(rSet.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return user;
	}
	
	// 根据学号查询
	public User findByStuid(String stuid) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from user where stuid=?";
		PreparedStatement pstmt = null;
		User user = null;
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, stuid);
			
			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				user = new User(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5), rSet.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return user;
	}
	
/*	// 根据用户id查询 ---- 获取用户信息
	public User findById(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "select * from user where id=?";
		PreparedStatement pstmt = null;
		User user = null;
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				user = new User(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4),
						rSet.getString(5), rSet.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return user;
	}*/
}



