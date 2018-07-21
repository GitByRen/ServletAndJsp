package com.important.tag;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TestForeach extends SimpleTagSupport {

	private Collection<?> items;
	private String var;

	public void setItems(Collection<?> items) {
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (items != null) {
			for (Object object : items) {
				getJspContext().setAttribute(var, object);
				getJspBody().invoke(null);
			}
		}
	}

}
