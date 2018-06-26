package com.important.mvc.impl;

import java.util.List;

import com.important.mvc.dao.CustomerDAO;
import com.important.mvc.dao.DAO;
import com.important.mvc.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO {

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getCountWithName(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
