package org.adligo.tests4j_4gwt.client.model;

import java.util.List;

/**
 * a interface to 
 * @author scott
 *
 */
public interface I_GwtTrialWrapper {
	public Runnable getBeforeTrial();
	public Runnable getBeforeTests();
	public List<Runnable> getTests();
	public Runnable getAfterTests();
	public Runnable getAfterTrial();
}
