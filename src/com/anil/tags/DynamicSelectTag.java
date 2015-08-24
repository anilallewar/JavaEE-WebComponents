package com.anil.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This tag will iterate the contents provided in the list passed and create a
 * HTML SELECT list from the same
 */
public class DynamicSelectTag extends SimpleTagSupport implements
		DynamicAttributes {
	private List<Object> items;
	private String name;
	// Map to store the dynamic attributes
	private Map<String, Object> attributeMap = new HashMap<String, Object>();
	// This defines the format in which we want the attribute to be printed
	private static final String ATTRIB_FORMAT_TEMPLATE = "%s='%s' ";
	// This defines the format of the option statements
	private static final String OPTION_FORMAT_TEMPLATE = " <option value='%1$s'> %1$s </option>";

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
	public void setName(String varName) {
		this.name = varName;
	}

	/**
	 * This method is called by the container to set the attributes which do NOT
	 * have a corresonding setter method in the Tag
	 * 
	 * @param uri
	 *            - the XML namespace that defines the attribute. Normally, you
	 *            can ignore this parameter
	 * @param name
	 *            - The name of the attribute
	 * @param value
	 *            - The value of the attribute that can be any EL expression or
	 *            JSP scriptlet; basically anything that evaluates to an object
	 */
	public void setDynamicAttribute(String uri, String name, Object value)
			throws JspException {
		attributeMap.put(name, value);
	}

	/**
	 * This tag will iterate the contents provided in the list passed and create
	 * a HTML SELECT list from the same
	 */
	@Override
	public void doTag() throws JspException, IOException {
		/*
		 * getJspBody().invoke(null) - This tells the container to process the
		 * body of the tag and process it to response. When you pass NULL to the
		 * method, it means you want the body to be printed to the response and
		 * not to some specific writer that you would otherwise pass to the
		 * method.
		 */
		JspWriter out = getJspContext().getOut();

		// Start the HTML <select> tag
		out.print("<select ");

		// add mandatory attributes
		out.print(String.format(ATTRIB_FORMAT_TEMPLATE, "name", this.name));
		out.print(String.format(ATTRIB_FORMAT_TEMPLATE, "id", this.name));

		// add dynamic attributes
		for (String attribName : attributeMap.keySet()) {
			out.print(String.format(ATTRIB_FORMAT_TEMPLATE, attribName,
					attributeMap.get(attribName)));
		}

		// Add the ending tag
		out.println(">");

		// Add the options
		String optionTag = null;
		ListIterator<Object> iterator = items.listIterator();
		while (iterator.hasNext()) {
			optionTag = String.format(OPTION_FORMAT_TEMPLATE, iterator.next()
					.toString());
			out.println(optionTag);
		}

		// End the HTML select tag
		out.println("</select>");
	}
}
