package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.Form;
import util.DBUtil;
import vo.FormVo;

/**
 * 	申请表连接数据库
 * @author 汪wqs
 *
 * 2019年11月05日 上午8:14:17
 * 2019年11月12日
 * 2019年11月19日
 * 2019年12月02日
 */

public class FormDao {
	
	// 添加
	public int addForm(Form form) {
		// 创建连接
		Connection conn = DBUtil.getConn();
		// 准备SQL语句
		String sql = "insert into form(userid, applydate, start, end, number, ifmedia, reason, status, submitdatetime) values(?,?,?,?,?,?,?,?,?)";
		// PreparedStatement语句
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 设置参数
			pstmt.setInt(1, form.getUserid());
			pstmt.setString(2, form.getApplydate());
			pstmt.setString(3, form.getStart());
			pstmt.setString(4, form.getEnd());
			pstmt.setInt(5, form.getNumber());
			pstmt.setString(6, form.getIfmedia());
			pstmt.setString(7, form.getReason());
			pstmt.setString(8, form.getStatus());
			pstmt.setString(9, form.getSubmitdatetime());
			
			// 发送SQL语句
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
	
	// 删除
	public int deleteForm(int id) {
		// 创建连接
		Connection conn = DBUtil.getConn();
		// 准备SQL语句
		String sql = "delete from form where id=?";
		// PreparedStatement语句
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 设置参数
			pstmt.setInt(1, id);
			// 发送SQL语句
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return result;
	}
	
	public ArrayList<FormVo> findAll() {
		Connection conn = DBUtil.getConn();
		String sql = "select "
				+ "form.id, user.stuid, user.`name`, user.phone, applydate, `start`, `end`, number, ifmedia, reason, `status`, submitdatetime "
				+ "from " 
				+ "form left join `user` " 
				+ "on " 
				+ "form.userid = `user`.id "
				+ "order by applydate, start ";
		
		PreparedStatement pstmt = null;
		FormVo formVo = null;
		ArrayList<FormVo> formList = new ArrayList<FormVo>();
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				formVo = new FormVo(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), rSet.getString(5),
						rSet.getString(6), rSet.getString(7), rSet.getInt(8), rSet.getString(9), rSet.getString(10), rSet.getString(11), rSet.getString(12));
				
				formList.add(formVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return formList;
	}
	
	// 查询所有申请表(根据时间段)
	public ArrayList<FormVo> findAll(String date1, String date2) {
		Connection conn = DBUtil.getConn();
		String sql = "select "
				+ "form.id, user.stuid, user.`name`, user.phone, applydate, `start`, `end`, number, ifmedia, reason, `status`, submitdatetime "
				+ "from " 
				+ "form left join `user` " 
				+ "on " 
				+ "form.userid = `user`.id "
				+ "where applydate between ? and ? " 
				+ "order by applydate, start ";
		
		PreparedStatement pstmt = null;
		FormVo formVo = null;
		ArrayList<FormVo> formList = new ArrayList<FormVo>();
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, date1);
			pstmt.setString(2, date2);
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				formVo = new FormVo(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), rSet.getString(5),
						rSet.getString(6), rSet.getString(7), rSet.getInt(8), rSet.getString(9), rSet.getString(10), rSet.getString(11), rSet.getString(12));
				
				formList.add(formVo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return formList;
	}
	
	// 根据申请表审核状态查询所有
	public ArrayList<FormVo> findByStatus(String status) {
		Connection conn = DBUtil.getConn();
		String sql = "select "
				+ "form.id, user.stuid, user.`name`, user.phone, applydate, `start`, `end`, number, ifmedia, reason, `status`, submitdatetime "
				+ "from " 
				+ "form left join `user` " 
				+ "on " 
				+ "form.userid = `user`.id"
				+ "where "
				+ "status=? ";
		
		PreparedStatement pstmt = null;
		FormVo formVo = null;
		ArrayList<FormVo> formList = new ArrayList<FormVo>();
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				formVo = new FormVo(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), rSet.getString(5),
						rSet.getString(6), rSet.getString(7), rSet.getInt(8), rSet.getString(9), rSet.getString(10), rSet.getString(11), rSet.getString(12));
				
				formList.add(formVo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return formList;
	}
	
	// 根据申请表id查询
	public FormVo findById(int id) {
		Connection conn = DBUtil.getConn();
		String sql = "select "
				+ "form.id, user.stuid, user.`name`, user.phone, applydate, `start`, `end`, number, ifmedia, reason, `status`, submitdatetime "
				+ "from " 
				+ "form left join `user` " 
				+ "on " 
				+ "form.userid = `user`.id"
				+ "where "
				+ "form.id=? ";
		
		PreparedStatement pstmt = null;
		FormVo formVo = null;
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);

			rSet = pstmt.executeQuery();
			while (rSet.next()) {
				formVo = new FormVo(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), rSet.getString(5),
						rSet.getString(6), rSet.getString(7), rSet.getInt(8), rSet.getString(9), rSet.getString(10), rSet.getString(11), rSet.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return formVo;
	}
	
	// 根据申请人userid查询所有
	public ArrayList<FormVo> findByUserid(int userid) {
		Connection conn = DBUtil.getConn();
		String sql = "select "
				+ "form.id, user.stuid, user.`name`, user.phone, applydate, `start`, `end`, number, ifmedia, reason, `status`, submitdatetime "
				+ "from " 
				+ "form left join `user` " 
				+ "on " 
				+ "form.userid = `user`.id"
				+ "where "
				+ "form.userid=? ";
		
		PreparedStatement pstmt = null;
		FormVo formVo = null;
		ArrayList<FormVo> formList = new ArrayList<FormVo>();
		ResultSet rSet = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				formVo = new FormVo(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), rSet.getString(5),
						rSet.getString(6), rSet.getString(7), rSet.getInt(8), rSet.getString(9), rSet.getString(10), rSet.getString(11), rSet.getString(12));
				
				formList.add(formVo);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeRst(rSet);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return formList;
	}
	
	public int updateStatus(int formid, String status){
		Connection connection = DBUtil.getConn();
		String sql = "update form set status=? where id=?";
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, status);
			preparedStatement.setInt(2, formid);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closePstmt(preparedStatement);
			DBUtil.closeConn(connection);
		}
		return result;
	}
}
