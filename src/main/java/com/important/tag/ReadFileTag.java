package com.important.tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ReadFileTag extends SimpleTagSupport {

	private String src;

	public void setSrc(String src) {
		this.src = src;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) getJspContext();
		InputStream in = pageContext.getServletContext().getResourceAsStream(src);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while ((str = br.readLine()) != null) {
			Pattern.compile("<").matcher(str).replaceAll("&lt");
			Pattern.compile(">").matcher(str).replaceAll("&gt");
			JspWriter out = pageContext.getOut();
			out.write(str);
			out.write("<br/>");
		}
	}

}
