package org.adligo.tests4j_4gwt.client.model.run;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j.models.shared.trials.I_MetaTrial;

public class GwtTests4J_Params {
	private List<I_GwtTrialWrapper> trials = new ArrayList<I_GwtTrialWrapper>();
	private I_MetaTrial metaTrial;
	
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

	public I_MetaTrial getMetaTrial() {
		return metaTrial;
	}

	public void setMetaTrial(I_MetaTrial metaTrial) {
		this.metaTrial = metaTrial;
	}
}
