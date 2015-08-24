/*
 * Created on Jan 6, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.listenerexample.model;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author aallewar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Dog implements HttpSessionBindingListener, HttpSessionActivationListener {

	private String breed=null;
	/**
	 * The constructor which takes the Dog breed name
	 */
	public Dog(String breed){
		this.breed =  breed;
	}
	
	/**
	 * Getter method for returning the breed value
	 * @return String
	 */
	public String getBreed(){
		return this.breed;
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionBindingListener#valueBound(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("com.anil.listenerexample.model.Dog	:" + "I am the Dog now being BOUND TO Session: " + this.toString());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionBindingListener#valueUnbound(javax.servlet.http.HttpSessionBindingEvent)
	 */
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("com.anil.listenerexample.model.Dog	:" +  "I am the Dog now being REMOVED FROM Session: " + this.toString());

	}
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionActivationListener#sessionDidActivate(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDidActivate(HttpSessionEvent event) {
		System.out.println("com.anil.listenerexample.model.Dog	:" + "The session is being ACTIVATED on this JVM" + event.getSession().getId());
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionActivationListener#sessionWillPassivate(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionWillPassivate(HttpSessionEvent event) {
		System.out.println("com.anil.listenerexample.model.Dog	:" + "The session is being PASSIVATED on this JVM" + event.getSession().getId());
	}
}
