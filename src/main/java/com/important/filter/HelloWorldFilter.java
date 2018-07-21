package com.important.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Filter：对请求和响应进行拦截，Filter随着servelt容器的加载而被加载
 * FilterChain：
 * ①把请求传给Filter链的下一个Filter,若当前Filter是Filter链的最后一个，则把请求给到目标Servlet(或JSP)
 * ②多个Filter拦截的顺序和<filter-mapping>配置的顺序有关，靠前的先被调用
 * ③Filter链执行顺序 1 3 5 4 2
 * ④<dispatcher>可以设置为REQUEST(如果是通过forward方法访问,该过滤器不会被调用),FORWARD(只有通过forward方法访问时才被调用),
 * ERROR(只有通过声明式异常处理机制调用时，该过滤器才会被调用，声明式异常就是在web.xml中用<error-page>声明的)
 */
public class HelloWorldFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("1.");
		chain.doFilter(request, response);
		System.out.println("2.");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
