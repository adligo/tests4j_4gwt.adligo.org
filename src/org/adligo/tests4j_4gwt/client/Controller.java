package org.adligo.tests4j_4gwt.client;

import java.util.List;

import org.adligo.tests4j_4gwt.client.model.I_GwtTrialWrapper;
import org.adligo.tests4j_4gwt.client.presenter.TrialRunPresenter;
import org.adligo.tests4j_4gwt.client.ui.I_TrialRunUi;

public class Controller {
	TrialRunPresenter presenter = new TrialRunPresenter();
	
	public Controller(I_TrialRunUi ui) {
		ui.resize();
		
	}
	
	public void setTrials(List<I_GwtTrialWrapper> trials) {
		presenter.setTrials(trials);
	}
}
