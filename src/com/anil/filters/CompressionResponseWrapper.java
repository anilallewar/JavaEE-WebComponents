package com.anil.filters;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CompressionResponseWrapper extends HttpServletResponseWrapper {

	private GZipServletOutputStream servletGZipOS = null;
	private PrintWriter pw = null;
	// This object is used to determine if Writer/OutputStream already
	// requested; if so
	// throw an IllegalStateException
	private Object streamUsed = null;

	/**
	 * Since the super class defines a non-empty constructor, you need to
	 * over-ride it
	 * 
	 * @param response
	 */
	public CompressionResponseWrapper(HttpServletResponse response) {
		super(response);
	}

	/**
	 * Utilty method to return the GZIPOutputStream so that we can finish
	 * writing from the Filter
	 * 
	 * @return GZIPOutputStream
	 */
	public GZIPOutputStream getGZipServletOutputStream() {
		return this.servletGZipOS.getOutputGZipStream();
	}

	/**
	 * This method wraps the servlet response stream into a
	 * GZipServletOutputStream and returns it
	 * 
	 * @see javax.servlet.ServletResponseWrapper#getOutputStream()
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {

		/*
		 * Throw an IllegalStateException if the user had already requested for
		 * PrintWriter. However, if he has accessed ServletOutputStream, then we
		 * allow him to access the ServletOutputStream
		 */
		if ((streamUsed != null) && (streamUsed == pw)) {
			// No need to declare as IllegalStateException is a run time
			// exception
			throw new IllegalStateException(
					"Already created a PrintWriter and hence cannot get an OutputStream on the same response.");
		}
		if (this.servletGZipOS == null) {
			this.servletGZipOS = new GZipServletOutputStream(getResponse()
					.getOutputStream());
			this.streamUsed = this.servletGZipOS;
		}
		return this.servletGZipOS;
	}

	/**
	 * This method wraps the GZip response stream into a PrintWriter and returns
	 * it
	 * 
	 * @see javax.servlet.ServletResponseWrapper#getWriter()
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		/*
		 * Throw an IllegalStateException if the user had already requested for
		 * ServletOutputStream. However, if he has accessed PrintWriter, then we
		 * allow him to access the PrintWriter
		 */
		if ((streamUsed != null) && (streamUsed == servletGZipOS)) {
			// No need to declare as IllegalStateException is a run time
			// exception
			throw new IllegalStateException(
					"Already created a ServletOutputStream and hence cannot get an PrintWriter on the same response.");
		}

		if (this.pw == null) {
			// First - get the response output stream on which you want to
			// create a stream
			this.servletGZipOS = new GZipServletOutputStream(getResponse()
					.getOutputStream());
			// Second - Wrap the response output steam on a OutputStreamWriter.
			// An OutputStreamWriter is a bridge from
			// character streams to byte streams
			OutputStreamWriter osw = new OutputStreamWriter(this.servletGZipOS,
					getResponse().getCharacterEncoding());
			// Third - wrap the OutputStreamWriter with a PrintWriter
			this.pw = new PrintWriter(osw);

			this.streamUsed = this.pw;
		}

		return this.pw;
	}

}
