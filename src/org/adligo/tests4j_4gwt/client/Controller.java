package org.adligo.tests4j_4gwt.client;

import org.adligo.tests4j_4gwt.client.model.run.GwtTests4J_Params;
import org.adligo.tests4j_4gwt.client.presenter.TrialRunPresenter;
import org.adligo.tests4j_4gwt.client.ui.I_TrialRunUi;

public class Controller {
	TrialRunPresenter presenter = new TrialRunPresenter();
	
	public Controller(I_TrialRunUi ui) {
		ui.resize();
		presenter.setUi(ui);
	}
	
	public void setParams(GwtTests4J_Params params) {
		presenter.setParams(params);
	}
}
