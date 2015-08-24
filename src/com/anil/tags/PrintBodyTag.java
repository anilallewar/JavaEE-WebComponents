package com.anil.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintBodyTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException{
		System.out.println("com.anil.tags.PrintBodyTag: doTag() called");
		getJspBody().invoke(null);
	}
}
