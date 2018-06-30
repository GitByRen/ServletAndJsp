package com.important.mvc.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.important.mvc.dao.CriteriaCustomer;
import com.important.mvc.dao.CustomerDAO;
import com.important.mvc.domain.Customer;
import com.important.mvc.impl.CustomerDAOJdbcImpl;

class JdbcUtilsTest {

	
	@Test
	void testGetConnection() throws SQLException {
		CustomerDAO c = new CustomerDAOJdbcImpl();
		CriteriaCustomer cc = new CriteriaCustomer("阿敏", null, null);
		List<Customer> forListWithCriteriaCustomer = c.getForListWithCriteriaCustomer(cc);
		System.out.println(forListWithCriteriaCustomer);
	}

}
