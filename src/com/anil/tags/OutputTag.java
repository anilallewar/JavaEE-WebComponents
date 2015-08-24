package com.anil.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This tag will write the contents in the output string with the fontcolor that
 * the user has specified.
 */
public class OutputTag extends SimpleTagSupport {
	private String output;
	private String fontColor;

	/**
	 * @param output
	 *            the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * @param fontColor
	 *            the fontColor to set
	 */
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	/**
	 * This tag will write the contents in the output string with the fontcolor
	 * that the user has specified.
	 */
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print(
				"<font color=" + this.fontColor + ">" + this.output
						+ System.getProperty("line.separator") + "<br>");
		/*
		 * This tells the container to process the body of the tag and process
		 * it to response. When you pass NULL to the method, it means you want
		 * the body to be printed to the response and not to some specific
		 * writer that you would otherwise pass to the method.
		 */
		getJspContext().setAttribute("message", "Anil Allewar");
		if (getJspBody() != null) {
			getJspBody().invoke(null);
		}

		getJspContext().getOut().print("</font>");
	}
}
