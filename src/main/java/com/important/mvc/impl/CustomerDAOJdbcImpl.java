package com.important.mvc.impl;

import java.util.List;

import com.important.mvc.dao.CriteriaCustomer;
import com.important.mvc.dao.CustomerDAO;
import com.important.mvc.dao.DAO;
import com.important.mvc.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO {

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		String sql = "select * from customers where name LIKE ? and address LIKE ? and phone LIKE ?";
		return getForList(sql, cc.getName(), cc.getAddress(), cc.getPhone());
	}
	
	@Override
	public List<Customer> getAll() {
		String sql = "select * from customers";
		return getForList(sql, null);
	}

	@Override
	public void save(Customer customer) {

	}

	@Override
	public Customer get(Integer id) {
		return get(null, null);
	}

	@Override
	public void delete(Integer id) {
		String sql = "";
		update(sql, id);
	}

	@Override
	public long getCountWithName(String name) {
		return 0;
	}

}
