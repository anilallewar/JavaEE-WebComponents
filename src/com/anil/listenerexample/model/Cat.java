/*
 * Created on Jan 10, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.listenerexample.model;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * @author aallewar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Cat implements ServletRequestAttributeListener{
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeAdded(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("com.anil.listenerexample.model.Cat	:" + "The servlet request and context can be accessed from the ServletRequestAttributeEvent: " + event.getServletRequest().getCharacterEncoding() + "<BR>");
		System.out.println("com.anil.listenerexample.model.Cat	:" + "The request attribute added: " + event.getName() + " and the value is: " + event.getValue() + "<BR>");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeRemoved(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("com.anil.listenerexample.model.Cat	:" + "The request attribute removed: " + event.getName() + " and the value is: " + event.getValue() + "<BR>");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeReplaced(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("com.anil.listenerexample.model.Cat	:" + "The request attribute replaced: " + event.getName() + " and the value is: " + event.getValue() + "<BR>");
	}
}
