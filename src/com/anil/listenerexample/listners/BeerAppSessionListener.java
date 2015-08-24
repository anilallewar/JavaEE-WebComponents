/*
 * Created on Jan 10, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.listenerexample.listners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author aallewar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BeerAppSessionListener implements HttpSessionListener {

	private static int sessionCount=1;
	
	/**
	 * Get the session count of how many sessions are currently active in the servlet
	 * @return
	 */
	public int getSessionCount(){
		return sessionCount;
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("com.anil.listenerexample.listners.BeerAppSessionListener	:" + "The session # is created: " + ++sessionCount);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("com.anil.listenerexample.listners.BeerAppSessionListener	:" + "The session # is destroyed: " + sessionCount--);
	}

}
