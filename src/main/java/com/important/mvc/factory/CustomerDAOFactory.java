package com.important.mvc.factory;

import java.util.HashMap;
import java.util.Map;

import com.important.mvc.dao.CustomerDAO;
import com.important.mvc.impl.CustomerDAOJdbcImpl;
import com.important.mvc.impl.CustomerDAOXMLImpl;

/**
 * 单例工厂
 */
public class CustomerDAOFactory {

	private Map<String, CustomerDAO> daos = new HashMap<>();

	private CustomerDAOFactory() {
		daos.put("jdbc", new CustomerDAOJdbcImpl());
		daos.put("xml", new CustomerDAOXMLImpl());
	}

	private static CustomerDAOFactory instance = new CustomerDAOFactory();

	public static CustomerDAOFactory getInstance() {
		return instance;
	}

	private String type = null;

	public void setType(String type) {
		this.type = type;
	}

	public CustomerDAO getCustomerDao() {
		return daos.get(type);
	}

}
