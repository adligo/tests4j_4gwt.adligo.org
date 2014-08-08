package org.adligo.tests4j_4gwt.client.model.run;

import java.util.ArrayList;
import java.util.List;

public class GwtTests4J_Params {
	private List<I_GwtTrialWrapper> trials = new ArrayList<I_GwtTrialWrapper>();

	public List<I_GwtTrialWrapper> getTrials() {
		return trials;
	}

	public void setTrials(List<I_GwtTrialWrapper> p) {
		if (p != null) {
			trials.clear();
			trials.addAll(p);
		}
	}
	
	public void addTrial(I_GwtTrialWrapper p) {
		if (p != null) {
			trials.add(p);
		}
	}
}
