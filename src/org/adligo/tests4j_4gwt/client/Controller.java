package org.adligo.tests4j_4gwt.client;

import org.adligo.tests4j.shared.common.DelegateSystem;
import org.adligo.tests4j.shared.common.Tests4J_System;
import org.adligo.tests4j_4gwt.client.model.run.GwtTests4J_Params;
import org.adligo.tests4j_4gwt.client.presenter.TrialRunPresenter;
import org.adligo.tests4j_4gwt.client.ui.I_TrialRunUi;

public class Controller {
	TrialRunPresenter presenter = new TrialRunPresenter();
	
	public Controller(I_TrialRunUi ui) {
		((DelegateSystem) Tests4J_System.SYSTEM).setDelegate(new GwtSystem());
		ui.resize();
		presenter.setUi(ui);
	}
	
	public void setParams(GwtTests4J_Params params) {
		presenter.setParams(params);
	}
}
