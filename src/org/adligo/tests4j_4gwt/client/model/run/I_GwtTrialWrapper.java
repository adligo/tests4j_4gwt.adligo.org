package org.adligo.tests4j_4gwt.client.model.run;

import java.util.List;

import org.adligo.tests4j.models.shared.trials.I_Trial;

/**
 * a interface to 
 * @author scott
 *
 */
public interface I_GwtTrialWrapper {
	public String getName();
	public I_Trial getTrial();
	public I_GwtTrialDescription getDescription();
	public I_GwtMethodWrapper getBeforeTrial();
	public I_GwtMethodWrapper getBeforeTests();
	public List<I_GwtMethodWrapper> getTests();
	public I_GwtMethodWrapper getAfterTests();
	public I_GwtMethodWrapper getAfterTrial();
}
