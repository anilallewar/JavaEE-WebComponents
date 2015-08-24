package com.anil.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * This <b>CLASSIC</b> tag will write the contents in the output string with the
 * fontcolor that the user has specified.
 */
@SuppressWarnings("serial")
public class ClassicOutputTag extends TagSupport {
	private String output;

	/**
	 * @param output
	 *            the output to set
	 */
	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * This tag will write the contents in the output string with the fontcolor
	 * that the user has specified.
	 */

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		try {
			out
					.println("This is from the ClassicOutputTag tag <b>doStartTag()</b> method. <br>");
			out.println(this.output + System.getProperty("line.separator")
					+ "<br>");
		} catch (IOException ioException) {
			// Can't declare that the method throws IOException.
			// The overriding method can only throw fewer or narrower exceptions
			throw new JspException("IOException: " + ioException.getMessage());
		}

		/*
		 * SKIP_BODY - This tells not to evaluate the body and go straight to
		 * the doEndTag() method EVAL_BODY_INCLUDE - This tells the container to
		 * evaluate the body ONLY once
		 */
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();

		try {
			out
					.println("This is from the ClassicOutputTag tag <b>doEndTag()</b> method. <br>");
		} catch (IOException ioException) {
			// Can't declare that the method throws IOException.
			// The overriding method can only throw fewer or narrower exceptions
			throw new JspException("IOException: " + ioException.getMessage());
		}

		/*
		 * EVAL_PAGE - This tells to evaluate the rest of the page. SKIP_PAGE -
		 * If you return a SKIP_PAGE it is basically same as throwing a
		 * SkipPageException and will cause rest of the page to NOT render.
		 */
		return EVAL_PAGE;
	}
}
