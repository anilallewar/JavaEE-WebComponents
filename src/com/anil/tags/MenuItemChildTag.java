package com.anil.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This child tag will hold the values that you want to pass to the parent tag
 */
public class MenuItemChildTag extends SimpleTagSupport {
	private String itemValue;

	/**
	 * This method is used to set the menu item
	 */
	@Override
	public void doTag() throws JspException, IOException {
		MenuParentTag parent = (MenuParentTag) this.getParent();
		parent.setMenuitem(this.itemValue);
	}

	/**
	 * @param menuitem
	 *            the menuitem to set
	 */
	public void setItemValue(String menuitem) {
		this.itemValue = menuitem;
	}
}
