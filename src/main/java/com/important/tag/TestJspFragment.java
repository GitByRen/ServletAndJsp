package com.important.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestJspFragment extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// JspFragment对象封装了标签体信息
		JspFragment bodyContent = getJspBody();
		/*
		 * JspFragment.invoke(Writer):Writer即为标签体内容输出的字符流;
		 * 若为null,则输出到getJspContext().getOut(),即页面上
		 */

		// 1.利用StringWriter得到标签体内容
		StringWriter sw = new StringWriter();
		bodyContent.invoke(sw);

		// 2.把标签体的内容变为大写
		String upperCase = sw.toString().toUpperCase();

		// 3.获取out输出
		getJspContext().getOut().print(upperCase);
	}

}
