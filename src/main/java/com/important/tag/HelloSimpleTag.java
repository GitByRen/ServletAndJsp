package com.important.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag implements SimpleTag {

	private String value;
	private String count;

	public void setValue(String value) {
		this.value = value;
	}

	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * 标签体实际逻辑
	 */
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = pageContext.getOut();
		int c = 0;
		c = Integer.parseInt(count);
		for (int i = 0; i < c; i++) {
			out.print(value);
			out.print("<br/>");
		}
	}

	@Override
	public JspTag getParent() {
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {

	}

	private PageContext pageContext;

	/**
	 * JSP引擎调用，把代表jsp页面的PageContext对象传入, PageContext可以获取JSP页面其他8个隐含对象
	 */
	@Override
	public void setJspContext(JspContext arg0) {
		this.pageContext = (PageContext) arg0;
	}

	@Override
	public void setParent(JspTag arg0) {

	}

}
