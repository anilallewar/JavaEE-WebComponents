package com.anil.filters;

import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * This is a decorator class that is used to provide compression on the standard
 * ServletOutputStream.
 * 
 * @author anila
 * 
 */
public class GZipServletOutputStream extends ServletOutputStream {

	private GZIPOutputStream outputGZipStream;

	/**
	 * Decorator constructor
	 * 
	 * @param out
	 *            - the ServletOutputStream passed
	 * @throws IOException
	 */
	public GZipServletOutputStream(ServletOutputStream out) throws IOException {
		this.outputGZipStream = new GZIPOutputStream(out);
	}

	/**
	 * This method delegates the writing to the GZIPOutputStream class
	 */
	@Override
	public void write(int b) throws IOException {
		this.outputGZipStream.write(b);
	}

	/**
	 * @return the outputGZipStream
	 */
	public GZIPOutputStream getOutputGZipStream() {
		return outputGZipStream;
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener arg0) {
		// TODO Auto-generated method stub
		
	}
}
