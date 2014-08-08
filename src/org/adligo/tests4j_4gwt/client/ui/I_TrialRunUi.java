package org.adligo.tests4j_4gwt.client.ui;


public interface I_TrialRunUi {
	
	public void clearResults();
	
	public void addTrial(String trial);
	
	public void addTest(String trial, String test, boolean passed);
	
	public void setTrialPassed(boolean passed);
	
	public void showTestWidget(Object o);
	
	public void setTotalTests(int p);
	
	public void setRunHandler(I_RunHandler handler);

	public void resize();

	public I_ConsoleUi getConsole();
	
	public int getLineBufferSetting();
}
