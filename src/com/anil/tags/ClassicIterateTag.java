package com.anil.tags;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * This <b>CLASSIC</b> tag will iterate the contents provided in the list passed
 * and write it to the tag body one by one
 */
@SuppressWarnings("serial")
public class ClassicIterateTag extends TagSupport {
	private List<Object> listitems;
	private String variable;
	private ListIterator<Object> iterator;

	/**
	 * This method is called ONLY once when the tag is evaludated at the start
	 * of tag evaluation
	 */
	@Override
	public int doStartTag() throws JspException {
		iterator = listitems.listIterator();
		if (iterator.hasNext()){
			pageContext.setAttribute(variable, iterator.next());
		}else{
			System.out.println("Skipping the body as no values were provided in the list");
			return SKIP_BODY;
		}
		
		return EVAL_BODY_INCLUDE;
	}

	/**
	 * This method is called after the body has been evaluated. It is here that
	 * we iterate. The return EVAL_BODY_AGAIN causes the body to be evaluated
	 * again and this method will be called again.
	 */
	@Override
	public int doAfterBody() throws JspException {

		while (iterator.hasNext()) {
			pageContext.setAttribute(variable, iterator.next());
			return EVAL_BODY_AGAIN;
		}
		try{
			pageContext.getOut().print("Calling after iteration");
		}catch (IOException ioe){
			System.out.println("Exception while writing from doAfterBody() method");
		}
		return SKIP_BODY;
	}

	/**
	 * This method is called ONLY once when the tag is evaludated at the end of
	 * tag evaluation
	 */
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setListitems(List<Object> items) {
		this.listitems = items;
	}

	/**
	 * @param varName
	 *            the varName to set
	 */
	public void setVariable(String varName) {
		this.variable = varName;
	}

}
