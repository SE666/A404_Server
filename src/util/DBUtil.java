package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *	 数据库操作工具类
 * 
 * @author 汪wqs
 *
 * 2019年10月30日 下午2:52:37
 */

public class DBUtil {
	public static String URL;
	public static String USERNAME;
	public static String PASSWORD;
	public static String DRIVER;
	private static ResourceBundle rb = ResourceBundle.getBundle("util.db-config");

	private DBUtil() {
	}

	static {
		URL = rb.getString("jdbc.url");
		USERNAME = rb.getString("jdbc.username");
		PASSWORD = rb.getString("jdbc.password");
		DRIVER = rb.getString("jdbc.driver");

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 	获取数据库连接的方法
	 * 
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Get Database Connection failed.");
		}

		return conn;
	}

	/**
	 * 关闭数据库连接
	 * 
	 */
	// 关闭连接
	public static void closeConn(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭preparedStatement
	public static void closePstmt(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 关闭结果集ResultSet
	public static void closeRst(ResultSet rst) {
		try {
			rst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
