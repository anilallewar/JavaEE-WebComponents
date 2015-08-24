package com.anil.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * This tag throw a SkipPageException to the response. What this does it to print 
	 * everything on the page till that point when the tag is invoked BUT do not print
	 * anything after the tag.
 */
public class SkipPageExceptionThrowTag extends SimpleTagSupport {
	/**
	 * This tag throw a SkipPageException to the response. What this does it to print 
	 * everything on the page till that point when the tag is invoked BUT do not print
	 * anything after the tag.
	 */
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print("Message from within SkipPageExceptionThrowTag doTag() method.<br>");
		getJspContext().getOut().print("Throwing a JSP SkipPageException.....<br>");
		try{
			int i = 10/0; //will throw Arithmatic Exception
		}catch(Exception exception){
			System.out.println(this.getClass().getName() + " : Got exception in doTag() method: " + exception.getMessage());
			//SkipPageException extends JspException
			throw new SkipPageException();
		}
	}
}
