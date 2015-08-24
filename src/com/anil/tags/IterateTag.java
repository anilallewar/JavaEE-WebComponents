package com.anil.tags;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This tag will iterate the contents provided in the list passed and write it
 * to the tag body one by one
 */
public class IterateTag extends SimpleTagSupport {
	private List<Object> items;
	private String varName;

	/**
	 * This tag will iterate the contents provided in the list passed and write
	 * it to the tag body one by one
	 */
	@Override
	public void doTag() throws JspException, IOException {
		/*
		 * This tells the container to process the body of the tag and process
		 * it to response. When you pass NULL to the method, it means you want
		 * the body to be printed to the response and not to some specific
		 * writer that you would otherwise pass to the method.
		 */
		ListIterator<Object> iterator = items.listIterator();
		while (iterator.hasNext()) {
			getJspContext().setAttribute(varName, iterator.next());
			if (getJspBody() != null) {
				getJspBody().invoke(null);
			}
		}
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<Object> items) {
		this.items = items;
	}

	/**
	 * @param varName
	 *            the varName to set
	 */
	public void setVarName(String varName) {
		this.varName = varName;
	}

}
