package com.important.mvc.impl;

import java.util.List;

import com.important.mvc.dao.CriteriaCustomer;
import com.important.mvc.dao.CustomerDAO;
import com.important.mvc.domain.Customer;

public class CustomerDAOXMLImpl implements CustomerDAO{

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		
		return null;
	}

	@Override
	public List<Customer> getAll() {
		System.out.println("getAll");
		return null;
	}

	@Override
	public void save(Customer customer) {
		
	}

	@Override
	public Customer get(Integer id) {
		return null;
	}

	@Override
	public void delete(Integer id) {
		
	}

	@Override
	public long getCountWithName(String name) {
		return 0;
	}

}
