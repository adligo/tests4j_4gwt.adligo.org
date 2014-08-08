package org.adligo.tests4j_4gwt.client.model.run;

import org.adligo.tests4j.models.shared.common.I_TrialType;

public class GwtTrialDescription implements I_GwtTrialDescription {
	private String trialName;
	private I_TrialType type;
	
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_4gwt.client.model.run.I_GwtTrialDescription#getTrialName()
	 */
	@Override
	public String getTrialName() {
		return trialName;
	}
	/* (non-Javadoc)
	 * @see org.adligo.tests4j_4gwt.client.model.run.I_GwtTrialDescription#getType()
	 */
	@Override
	public I_TrialType getType() {
		return type;
	}
	public void setTrialName(String trialName) {
		this.trialName = trialName;
	}
	public void setType(I_TrialType type) {
		this.type = type;
	}
}
