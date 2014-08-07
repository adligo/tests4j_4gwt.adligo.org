package org.adligo.tests4j_4gwt.client;

import org.adligo.tests4j_4gwt.client.view.TrialRunView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Tests4J_EntryPoint implements EntryPoint {


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		TrialRunView view = new TrialRunView();
		RootPanel.get().add(view);

	}
}
