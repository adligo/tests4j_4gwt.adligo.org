package org.adligo.tests4j_4gwt.client.model.run;

import java.util.List;

import org.adligo.tests4j.models.shared.results.TrialFailure;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Listener;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.shared.common.StackTraceBuilder;

public class GwtTests4J_TrialRunner {
	private I_Trial trial;
	private I_GwtTrialWrapper trialWrapper;
	private I_Tests4J_Listener listener;
	private GwtTests4J_AssertListener assertionListener;
	
	public void setTrial(I_Trial trial, I_GwtTrialWrapper wrapper) {
		this.trial = trial;
		trialWrapper = wrapper;
	}
	
	public void run() {
		String trialName = trial.getClass().getName();
		listener.onStartingTrial(trialName);
		assertionListener.startNewTrial(trialWrapper.getDescription());
		I_GwtMethodWrapper beforeTrial = trialWrapper.getBeforeTrial();
		if (beforeTrial != null) {
			try {
				beforeTrial.run();
			} catch (Throwable x) {
				//the stack is available in dev mode
				TrialFailure failure = new TrialFailure("beforeTrial threw a error.", StackTraceBuilder.toString(x, true));
				assertionListener.trialFailed(failure);
				return;
			}
		}
		I_GwtMethodWrapper beforeTests = trialWrapper.getBeforeTests();
		I_GwtMethodWrapper afterTests = trialWrapper.getAfterTests();
		List<I_GwtMethodWrapper> tests = trialWrapper.getTests();
		for (I_GwtMethodWrapper test: tests) {
			String testName = test.getName();
			listener.onStartingTest(trialName, testName);
			assertionListener.startNewTest(testName);
			if (beforeTests != null) {
				try {
					beforeTests.run();
				} catch (Throwable x) {
					//the stack is available in dev mode
					TrialFailure failure = new TrialFailure("beforeTests threw a error.", StackTraceBuilder.toString(x, true));
					assertionListener.trialFailed(failure);
					return;
				}
			}
			try {
				test.run();
				listener.onTestCompleted(trialName, testName, true);
			} catch (GwtAssertionFailedException j) {
				listener.onTestCompleted(trialName, testName, false);
			} catch (Throwable x) {
				listener.onTestCompleted(trialName, testName, false);
				//the stack is available in dev mode
				TrialFailure failure = new TrialFailure(testName + " threw a error.", StackTraceBuilder.toString(x, true));
				assertionListener.trialFailed(failure);
				return;
			}
			
			if (beforeTests != null) {
				try {
					beforeTests.run();
				} catch (Throwable x) {
					//the stack is available in dev mode
					TrialFailure failure = new TrialFailure("beforeTests threw a error.", StackTraceBuilder.toString(x, true));
					assertionListener.trialFailed(failure);
					return;
				}
			}
			
			if (afterTests != null) {
				try {
					afterTests.run();
				} catch (Throwable x) {
					//the stack is available in dev mode
					TrialFailure failure = new TrialFailure("afterTests threw a error.", StackTraceBuilder.toString(x, true));
					assertionListener.trialFailed(failure);
					return;
				}
			}
		}
		
		I_GwtMethodWrapper afterTrial = trialWrapper.getBeforeTrial();
		if (afterTrial != null) {
			try {
				afterTrial.run();
			} catch (Throwable x) {
				//the stack is available in dev mode
				TrialFailure failure = new TrialFailure("afterTrial threw a error.", StackTraceBuilder.toString(x, true));
				assertionListener.trialFailed(failure);
				return;
			}
		}
	}

	public I_Tests4J_Listener getListener() {
		return listener;
	}

	public void setListener(I_Tests4J_Listener listener) {
		this.listener = listener;
	}

	public GwtTests4J_AssertListener getAssertionListener() {
		return assertionListener;
	}

	public void setAssertionListener(GwtTests4J_AssertListener assertionListener) {
		this.assertionListener = assertionListener;
	}
	
	
}
