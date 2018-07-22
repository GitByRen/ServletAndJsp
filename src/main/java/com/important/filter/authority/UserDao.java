package com.important.filter.authority;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {

	private static Map<String, User> users;

	private static List<Authority> authorities = null;

	static {
		authorities = new ArrayList<>();
		authorities.add(new Authority("Article-1", "/Filter/authority/article-1.jsp"));
		authorities.add(new Authority("Article-2", "/Filter/authority/article-2.jsp"));
		authorities.add(new Authority("Article-3", "/Filter/authority/article-3.jsp"));
		authorities.add(new Authority("Article-4", "/Filter/authority/article-4.jsp"));

		users = new HashMap<String, User>();

		User user1 = new User("AAA", authorities.subList(0, 2));
		users.put("AAA", user1);

		User user2 = new User("BBB", authorities.subList(2, 4));
		users.put("BBB", user2);
	}

	public User get(String username) {
		return users.get(username);
	}

	public void update(String username, List<Authority> authorities) {
		users.get(username).setAuthorities(authorities);
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	// 根据url返回封装的Authority的List
	public List<Authority> getAuthorities(String[] urls) {
		List<Authority> list = new ArrayList<>();

		if (urls == null) {
			return null;
		}

		for (Authority auth : authorities) {
			for (String url : urls) {
				if (url.equals(auth.getUrl())) {
					list.add(auth);
				}
			}
		}

		return list;
	}
}
