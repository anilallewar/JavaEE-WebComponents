package com.anil.filters;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompressOutputFilter implements Filter {

	private FilterConfig filterConfig;
	private ServletContext servletContext;

	/**
	 * This method is called at Filter initialization and we will use it to set
	 * our class level FilterConfig and ServletContext to the one passed from
	 * container
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.servletContext = filterConfig.getServletContext();
	}

	public void destroy() {
		// Set the instance variable to null to enable GC
		this.filterConfig = null;
		this.servletContext = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String validEncodings = httpRequest.getHeader("Accept-Encoding");
		servletContext.log(filterConfig.getFilterName()
				+ " : The allowed encoding are: " + validEncodings);

		// Check if gzip is one of the valid encodings
		if ((validEncodings != null) && (validEncodings.indexOf("gzip") > -1)) {
			CompressionResponseWrapper wrappedResponse = new CompressionResponseWrapper(
					httpResponse);
			/*
			 * If you comment out this code, the browser will use the default
			 * content encoding and you will see garbage on screen
			 */
			wrappedResponse.setHeader("Content-Encoding", "gzip");
			// Forward the request to the resource with our custom response
			chain.doFilter(httpRequest, wrappedResponse);

			/*
			 * A GZIP compression stream must be "finished" which flushes the
			 * GZIP stream buffer and sends all the data to the original
			 * response stream.
			 */
			GZIPOutputStream outStream = wrappedResponse
					.getGZipServletOutputStream();
			outStream.finish();

			servletContext.log(filterConfig.getFilterName()
					+ " : finished the request.");
		} else {
			servletContext
					.log(filterConfig.getFilterName()
							+ " : No encoding required as the browser does not accept GZIP.");
			// Need to handle the request
			chain.doFilter(request, response);
		}
	}
}
