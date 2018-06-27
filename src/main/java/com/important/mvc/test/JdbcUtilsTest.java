package com.important.mvc.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.important.mvc.db.JdbcUtils;

class JdbcUtilsTest {

	@Test
	void testGetConnection() throws SQLException {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}

}
