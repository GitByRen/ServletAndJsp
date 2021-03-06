package com.important.mvc.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * JDBC操作的工具类
 *
 */
public class JdbcUtils {

	/**
	 * 释放Connection连接
	 */
	public static void release(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static DataSource dataSource = null;
	
	static {
		// 数据源只能被创建一次
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	/**
	 * 返回数据源的一个Connection对象
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
