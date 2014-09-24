package org.adligo.tests4j_4gwt.client.model.run;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.models.shared.results.BaseTrialResult;
import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.TestResult;
import org.adligo.tests4j.models.shared.results.TestResultMutant;
import org.adligo.tests4j.shared.asserts.common.I_AssertCommand;
import org.adligo.tests4j.shared.asserts.common.I_AssertListener;
import org.adligo.tests4j.shared.asserts.common.I_TestFailure;
import org.adligo.tests4j.shared.asserts.common.TestFailure;

public class GwtTests4J_AssertListener implements I_AssertListener {
	private Map<String,BaseTrialResult> trialResults = new HashMap<String, BaseTrialResult>();
	private BaseTrialResultMutant currentTrial;
	private TestResultMutant currentTest;
	private boolean passed = true;
	
	public void startNewTrial(I_GwtTrialDescription desc) {
		if (currentTrial != null) {
			finishTrial();
		}
		currentTrial = new BaseTrialResultMutant();
		currentTrial.setTrialName(desc.getTrialName());
		currentTrial.setType(desc.getType());
	}

	public I_TrialResult finishTrial() {
		if (currentTest != null) {
			currentTest.setPassed(passed);
			currentTrial.addResult(new TestResult(currentTest));
		}
		passed = true;
		BaseTrialResult toRet = new BaseTrialResult(currentTrial);
		trialResults.put(currentTrial.getName(), toRet);
		currentTrial = null;
		currentTest = null;
		return toRet;
	}
	
	public void startNewTest(String name) {
		if (currentTest != null) {
			currentTest.setPassed(passed);
			currentTrial.addResult(new TestResult(currentTest));
		}
		passed = true;
		currentTest = new TestResultMutant();
		currentTest.setName(name);
	}
	
	@Override
	public void assertCompleted(I_AssertCommand cmd) {
		int hash = cmd.hashCode();
		currentTest.incrementAssertionCount(hash);
	}

	@Override
	public void assertFailed(I_TestFailure failure) {
		currentTest.setFailure(failure);
		passed = false;
		throw new GwtAssertionFailedException();
	}

	public void trialFailed(I_TrialFailure failure) {
		passed = false;
		currentTrial.addFailure(failure);
	}
	
	public List<I_TrialResult> getResults() {
		List<I_TrialResult> toRet = new ArrayList<I_TrialResult>();
		Collection<BaseTrialResult> results = trialResults.values();
		for (BaseTrialResult result: results) {
			toRet.add(result);
		}
		return toRet;
	}
	
	public void setPassed(boolean p) {
		passed = p;
	}
}
