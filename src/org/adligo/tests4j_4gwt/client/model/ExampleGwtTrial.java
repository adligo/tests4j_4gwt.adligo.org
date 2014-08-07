package org.adligo.tests4j_4gwt.client.model;

import java.util.ArrayList;
import java.util.List;

public class ExampleGwtTrial implements I_GwtTrialWrapper {

	@Override
	public Runnable getBeforeTrial() {
		return null;
	}

	@Override
	public Runnable getBeforeTests() {
		return null;
	}

	@Override
	public List<Runnable> getTests() {
		List<Runnable> toRet = new ArrayList<Runnable>();
		Runnable test = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
		return toRet;
	}

	@Override
	public Runnable getAfterTests() {
		return null;
	}

	@Override
	public Runnable getAfterTrial() {
		return null;
	}

}
