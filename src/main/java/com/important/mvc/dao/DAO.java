package com.important.mvc.dao;

import java.util.List;

/**
 * DAO
 */
public class DAO<T> {

	private Class<T> clazz;

	/**
	 * 返回某个字段的值：例如返回某条记录的名字
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql, Object... args) {
		return null;
	}

	/**
	 * 返回T对应的List
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql, Object... args) {
		return null;
	}

	/**
	 * 返回对应的T的一个实体类的对象
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql, Object... args) {
		return null;
	}

	/**
	 * 该方法封装了INSERT,UPDATE,DELETE
	 * 
	 * @param sql
	 * @param args
	 */
	public void update(String sql, Object... args) {

	}

}
