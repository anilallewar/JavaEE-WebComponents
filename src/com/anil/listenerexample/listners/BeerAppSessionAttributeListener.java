/*
 * Created on Jan 10, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.listenerexample.listners;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author aallewar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BeerAppSessionAttributeListener implements
		HttpSessionAttributeListener {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeAdded(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("com.anil.listenerexample.listners.BeerAppSessionAttributeListener	:" + "The session attribute ADDED to the session is: " + event.getName() + " And the value is: " + event.getValue());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeRemoved(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("com.anil.listenerexample.listners.BeerAppSessionAttributeListener	:" + "The session attribute REMOVED from the session is: " + event.getName() + " And the value is: " + event.getValue());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionAttributeListener#attributeReplaced(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("com.anil.listenerexample.listners.BeerAppSessionAttributeListener	:" + "The session attribute REPLACED in the session is: " + event.getName() + " And the value is: " + event.getValue());
	}

}
