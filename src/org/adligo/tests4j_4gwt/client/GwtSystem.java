package org.adligo.tests4j_4gwt.client;

import org.adligo.tests4j.shared.common.DefaultSystem;
import org.adligo.tests4j.shared.common.I_System;

import java.io.PrintStream;

public class GwtSystem implements I_System {

	@Override
	public void println(String p) {
		System.out.println(p);
	}

	@Override
	public void exitJvm(int p) {
		throw new IllegalStateException("exitJvm is not implemented in GWT.");
	}

	@Override
	public long getTime() {
		return System.currentTimeMillis();
	}

	/**
	 * this should only be used for printing to the 
	 * browser screen, where a line separator is wanted (ie stacktraces, text areas exc)
	 */
	@Override
	public String lineSeperator() {
		return "\n";
	}

	@Override
	public String getCurrentThreadName() {
		return DefaultSystem.DEFAULT_THREAD_NAME;
	}

	@Override
	public PrintStream getOut() {
		return System.out;
	}

	@Override
	public String getJseVersion() {
		return "NotJseButJavascript";
	}

	@Override
	public boolean isMainSystem() {
		// TODO Auto-generated method stub
		return false;
	}

  @Override
  public String getCurrentThreadGroupName() {
    return "UnknownThreadGroup";
  }

}
