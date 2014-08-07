package org.adligo.tests4j_4gwt.client.ui;

public interface I_ConsoleUi {
	/**
	 * adds a line to the console
	 * @param p
	 */
	public void log(String p, boolean removeTop);
	
	/**
	 * clear the console
	 */
	public void clear();
}
