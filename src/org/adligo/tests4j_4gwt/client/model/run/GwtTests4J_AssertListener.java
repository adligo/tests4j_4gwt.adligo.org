package org.adligo.tests4j_4gwt.client.model.run;

import java.util.HashMap;
import java.util.Map;

import org.adligo.tests4j.models.shared.asserts.common.I_AssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.I_TestFailure;
import org.adligo.tests4j.models.shared.asserts.common.TestFailure;
import org.adligo.tests4j.models.shared.results.BaseTrialResult;
import org.adligo.tests4j.models.shared.results.BaseTrialResultMutant;
import org.adligo.tests4j.models.shared.results.I_TrialFailure;
import org.adligo.tests4j.models.shared.results.TestResult;
import org.adligo.tests4j.models.shared.results.TestResultMutant;
import org.adligo.tests4j.models.shared.system.I_Tests4J_AssertListener;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GwtTests4J_AssertListener implements I_Tests4J_AssertListener {
	private Map<String,BaseTrialResult> trialResults = new HashMap<String, BaseTrialResult>();
	private BaseTrialResultMutant currentTrial;
	private TestResultMutant currentTest;
	
	public void startNewTrial(I_GwtTrialDescription desc) {
		if (currentTrial != null) {
			finishTrial();
		}
		currentTrial = new BaseTrialResultMutant();
		currentTrial.setTrialName(desc.getTrialName());
		currentTrial.setType(desc.getType());
	}

	public void finishTrial() {
		if (currentTest != null) {
			currentTrial.addResult(new TestResult(currentTest));
		}
		trialResults.put(currentTrial.getName(), new BaseTrialResult(currentTrial));
	}
	
	public void startNewTest(String name) {
		if (currentTest != null) {
			currentTrial.addResult(new TestResult(currentTest));
		}
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
		currentTest.setFailure(new TestFailure(failure));
		throw new GwtAssertionFailedException();
	}

	public void trialFailed(I_TrialFailure failure) {
		currentTrial.addFailure(failure);
	}
}
