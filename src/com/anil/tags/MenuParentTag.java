package com.anil.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This tag will be used to display the menu items that were added from the
 * child menu tags
 */
public class MenuParentTag extends SimpleTagSupport {
	private List<String> listitems = new ArrayList<String>();

	/**
	 * This method will print the menu items to response
	 */
	@Override
	public void doTag() throws JspException, IOException {
		
		/*
		 *First invoke the JSP body so that the nested tags are evaluated first and
		 *then the control returns to this method. 
		 *
		 *For a classic Tag, return a EVAL_BODY_INCLUDE from the doStartTag() nethod
		 *so that the body is evaluated and then you can print the data in either the
		 *doAfterBody() or doEndTag() methods. 
		 */
		getJspBody().invoke(null);
		
		ListIterator<String> iterator = listitems.listIterator();
		//hasNext() doesn't cause the iterator to go to the next item
		if (iterator.hasNext()) {
			getJspContext().getOut().print("[ ");
			while (iterator.hasNext()) {
				getJspContext().getOut().print(iterator.next() + " ");
			}
			getJspContext().getOut().print("]");
		} else {
			System.out
					.println("Skipping the body as no values were provided in the list");
		}
	}

	/**
	 * This method will be called the child tag to set the list of menu items
	 * 
	 * @param menuitem
	 *            the menuitem to set
	 */
	public void setMenuitem(String menuitem) {
		this.listitems.add(menuitem);
	}
}
