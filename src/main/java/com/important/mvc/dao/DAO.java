package com.important.mvc.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.important.mvc.db.JdbcUtils;

/**
 * DAO
 */
public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();

	private Class<T> clazz;

	public DAO() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) type;
			Type[] typeArgs = parameterizedType.getActualTypeArguments();
			if (typeArgs != null && typeArgs.length > 0) {
				if (typeArgs[0] instanceof Class) {
					clazz = (Class<T>) typeArgs[0];
				}
			}
		}
	}

	/**
	 * 返回某个字段的值：例如返回某条记录的名字
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public <E> E getForValue(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			return (E) queryRunner.query(connection, sql, new ScalarHandler(), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
		}
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
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
		}
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
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
		}
		return null;
	}

	/**
	 * 该方法封装了INSERT,UPDATE,DELETE
	 * 
	 * @param sql
	 * @param args
	 */
	public void update(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
		}
	}

}
