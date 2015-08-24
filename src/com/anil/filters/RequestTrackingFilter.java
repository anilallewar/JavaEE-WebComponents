/**
 * 
 */
package com.anil.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author anila
 * 
 */
public class RequestTrackingFilter implements Filter {

	private FilterConfig filterConfig;

	/**
	 * This method is called at Filter initialization and we will use it to set
	 * our class level FilterConfig to the one passed from container
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
	}

	/**
	 * This method will be called when the filter is destroyed
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		this.filterConfig.getServletContext().log(
				"com.anil.filters.RequestTrackingFilter : In destroy() method");
	}

	/**
	 * This method is called by the Container based on the filter order
	 * specified in the DD. <br>
	 * <br>
	 * If the request is for a constrained resource that requires user
	 * authentication, then this servlet will log the user name in the log file.
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// Type cast since we were passed the ServletRequest which is the parent
		// of HttpServletRequest
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		/*
		 * Returns the login of the user making this request, if the user has
		 * been authenticated, or null if the user has not been authenticated.
		 */
		String userName = httpRequest.getRemoteUser();
		
		if (userName != null) {
			//Puts the log statements in the localhost.log file
			this.filterConfig.getServletContext().log(
					"com.anil.filters.RequestTrackingFilter : Received the request for: "
							+ httpRequest.getRequestURL()
							+ " and the user who requested it is: " + userName);
		}

		// Forward the request to the next resource
		chain.doFilter(request, response);
	}
}
