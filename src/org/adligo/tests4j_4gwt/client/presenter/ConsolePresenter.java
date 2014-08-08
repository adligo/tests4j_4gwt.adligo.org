package org.adligo.tests4j_4gwt.client.presenter;

import java.util.HashMap;
import java.util.Map;

import org.adligo.tests4j.models.shared.asserts.line_text.TextLines;
import org.adligo.tests4j.models.shared.common.StackTraceBuilder;
import org.adligo.tests4j.models.shared.common.Tests4J_System;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;
import org.adligo.tests4j.shared.report.summary.DefaultReporterStates;
import org.adligo.tests4j_4gwt.client.ui.I_ConsoleUi;

public class ConsolePresenter implements I_Tests4J_Log {
	private Map<Class<?>, Boolean> active = new HashMap<Class<?>, Boolean>();
	private int bufferSize = 100;
	private int consoleMessages = 0;
	private I_ConsoleUi ui;
	
	public ConsolePresenter() {
		active.putAll(DefaultReporterStates.getDefalutLogStates());
	}
	@Override
	public void log(String p) {
		logPrivate(p);
	}

	public void clear() {
		consoleMessages = 0;
		ui.clear();
	}
	
	public void logPrivate(String p) {
		consoleMessages++;
		if (consoleMessages > bufferSize) {
			ui.log(p, true);
		} else {
			ui.log(p, false);
		}
	}
	
	@Override
	public void onException(Throwable p) {
		String stack = StackTraceBuilder.toString(p, true);
		TextLines lines = new TextLines(stack);
		for (int i = 0; i < lines.getLines(); i++) {
			String line = lines.getLine(i);
			logPrivate(line);
		}
	}

	@Override
	public boolean isLogEnabled(Class<?> clazz) {
		Boolean toRet =  active.get(clazz);
		if (toRet != null) {
			return toRet;
		}
		return false;
	}

	@Override
	public boolean isMainLog() {
		return true;
	}

	@Override
	public String getLineSeperator() {
		return Tests4J_System.getLineSeperator();
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public I_ConsoleUi getUi() {
		return ui;
	}

	public void setUi(I_ConsoleUi ui) {
		this.ui = ui;
	}

}
