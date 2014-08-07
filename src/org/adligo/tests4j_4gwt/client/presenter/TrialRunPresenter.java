package org.adligo.tests4j_4gwt.client.presenter;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j_4gwt.client.model.I_GwtTrialWrapper;

public class TrialRunPresenter {
	private List<I_GwtTrialWrapper> trials = new ArrayList<I_GwtTrialWrapper>();
	
	public void setTrials(List<I_GwtTrialWrapper> pTrials) {
		trials.clear();
		trials.addAll(pTrials);
	}
}
