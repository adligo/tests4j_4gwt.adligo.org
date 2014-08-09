package org.adligo.tests4j_4gwt.client.model.run;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookup;
import org.adligo.tests4j.models.shared.asserts.uniform.I_EvaluatorLookup;
import org.adligo.tests4j.models.shared.common.I_Platform;
import org.adligo.tests4j.models.shared.common.Platform;
import org.adligo.tests4j.models.shared.common.StackTraceBuilder;
import org.adligo.tests4j.models.shared.common.Tests4J_System;
import org.adligo.tests4j.models.shared.common.TrialType;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.results.I_TestResult;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.models.shared.results.TrialFailure;
import org.adligo.tests4j.models.shared.results.TrialRunResult;
import org.adligo.tests4j.models.shared.results.TrialRunResultMutant;
import org.adligo.tests4j.models.shared.system.I_Tests4J_AssertListener;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Listener;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;
import org.adligo.tests4j.models.shared.trials.I_MetaTrial;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.models.shared.trials.I_TrialBindings;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;

public class GwtTests4J_Processor implements I_TrialBindings {
	private GwtTests4J_AssertListener assertListener = new GwtTests4J_AssertListener();
	private I_EvaluatorLookup evaluatorLookup = EvaluatorLookup.DEFAULT_LOOKUP;
	private GwtTests4J_TrialRunner runner = new GwtTests4J_TrialRunner();
	private I_Tests4J_Listener reporter;
	private I_Tests4J_Log log;
	private long start;
	
	public GwtTests4J_Processor() {
		runner.setAssertionListener(assertListener);
	}
	@Override
	public I_Platform getPlatform() {
		return Platform.GWTC;
	}

	@Override
	public I_Tests4J_AssertListener getAssertListener() {
		return assertListener;
	}


	@Override
	public I_EvaluatorLookup getDefalutEvaluatorLookup() {
		return evaluatorLookup;
	}

	public void run(GwtTests4J_Params params) {
		start = Tests4J_System.getTime();
		runner.setListener(reporter);
		
		I_MetaTrial metaTrial = params.getMetaTrial();
		
		I_TrialRunMetadata metadata = calculateMetadata(params);
		
		
		List<I_GwtTrialWrapper> wrappers = params.getTrials();
		for (I_GwtTrialWrapper wrap: wrappers) {
			I_Trial trial = wrap.getTrial();
			trial.setBindings(this);
			runner.setTrial(trial, wrap);
			runner.run();
		}
		assertListener.finishTrial();
		I_TrialRunResult runResult = getRunResult();
		
		if (metaTrial != null) {
			runResult = runMetaTrial(metaTrial, metadata, runResult);
		}
		reporter.onRunCompleted(runResult);
	}
	private I_TrialRunResult runMetaTrial(I_MetaTrial metaTrial, I_TrialRunMetadata metadata, I_TrialRunResult runResult) {
		String trialName = metaTrial.getClass().getName();
		reporter.onStartingTrial(trialName);
		GwtTrialDescription desc = new GwtTrialDescription();
		desc.setTrialName(trialName);
		desc.setType(TrialType.MetaTrial);
		assertListener.startNewTrial(desc);
		
		String testName = "afterMetadataCalculated";
		metaTrial.setBindings(this);
		try {
			assertListener.startNewTest(testName);
			metaTrial.afterMetadataCalculated(metadata);
			assertListener.setPassed(true);
			reporter.onTestCompleted(trialName, testName, true);
		} catch (GwtAssertionFailedException x) {
			assertListener.setPassed(false);
			reporter.onTestCompleted(trialName, testName, false);
		} catch (Throwable g) {
			assertListener.setPassed(false);
			reporter.onTestCompleted(trialName, testName, false);
			//the stack is available in dev mode
			TrialFailure failure = new TrialFailure(testName + " threw a error.",
					StackTraceBuilder.toString(g, true));
			assertListener.trialFailed(failure);
		}
		
		testName = "afterNonMetaTrialsRun";
		try {
			assertListener.startNewTest(testName);
			metaTrial.afterNonMetaTrialsRun(runResult);
			assertListener.setPassed(true);
			reporter.onTestCompleted(trialName, testName, true);
		} catch (GwtAssertionFailedException x) {
			assertListener.setPassed(false);
			reporter.onTestCompleted(trialName, testName, false);
		} catch (Throwable g) {
			assertListener.setPassed(false);
			reporter.onTestCompleted(trialName, testName, false);
			//the stack is available in dev mode
			TrialFailure failure = new TrialFailure(testName + " threw a error.",
					StackTraceBuilder.toString(g, true));
			assertListener.trialFailed(failure);
		}
		I_TrialResult trialResult = assertListener.finishTrial();
		reporter.onTrialCompleted(trialResult);
		
		TrialRunResultMutant trrm = new TrialRunResultMutant(runResult);
		addResult(trrm, trialResult);
		addDuration(trrm);
		return new TrialRunResult(trrm);
	}
	
	private I_TrialRunResult getRunResult() {
		List<I_TrialResult> results = assertListener.getResults();
		TrialRunResultMutant trrm = new TrialRunResultMutant();
		for (I_TrialResult result: results) {
			addResult(trrm, result);
		}
		addDuration(trrm);
		return new TrialRunResult(trrm);
	}
	private void addDuration(TrialRunResultMutant trrm) {
		trrm.setStartTime(start);
		long end = Tests4J_System.getTime();
		long dur = end - start;
		trrm.setRunTime(dur);
	}
	private void addResult(TrialRunResultMutant trrm, I_TrialResult result) {
		trrm.addTrials(1);
		trrm.addTests(result.getTestCount());
		if (result.isPassed()) {
			trrm.addPassingTrial(result.getName());
		} else {
			trrm.addTrialFailures(1);
		}
		trrm.addTestFailures(result.getTestFailureCount());
		
		List<I_TestResult> testResults =  result.getResults();
		for (I_TestResult tr: testResults) {
			trrm.addAsserts(tr.getAssertionCount());
			trrm.addUniqueAsserts(tr.getUniqueAssertionCount());
		}
	}
	
	private I_TrialRunMetadata calculateMetadata(GwtTests4J_Params params) {
		TrialRunMetadataMutant trmm = new TrialRunMetadataMutant();
		List<I_GwtTrialWrapper> wrappers = params.getTrials();
		for (I_GwtTrialWrapper wrap: wrappers) {
			TrialMetadataMutant tmm = new TrialMetadataMutant();
			I_GwtTrialDescription desc = wrap.getDescription();
			tmm.setTrialName(desc.getTrialName());
			tmm.setType(desc.getType());
			
			List<I_GwtMethodWrapper> tests =  wrap.getTests();
			for (I_GwtMethodWrapper method: tests) {
				TestMetadataMutant testMm = new TestMetadataMutant();
				testMm.setTestName(method.getName());
				tmm.addTest(testMm);
			}
			trmm.addTrial(tmm);
		}
		I_MetaTrial metaTrial = params.getMetaTrial();
		if (metaTrial != null) {
			TrialMetadataMutant tmm = new TrialMetadataMutant();
			tmm.setTrialName(metaTrial.getClass().getName());
			tmm.setType(TrialType.MetaTrial);
			
			TestMetadataMutant testMm = new TestMetadataMutant();
			testMm.setTestName("afterMetadataCalculated");
			tmm.addTest(testMm);
			
			testMm = new TestMetadataMutant();
			testMm.setTestName("afterNonMetaTrialsRun");
			tmm.addTest(testMm);
			
			trmm.addTrial(tmm);
		}
		TrialRunMetadata metatdata = new TrialRunMetadata(trmm);
		reporter.onMetadataCalculated(metatdata);
		return metatdata;
	}

	public I_Tests4J_Log getLog() {
		return log;
	}

	public void setLog(I_Tests4J_Log log) {
		this.log = log;
	}
	public I_Tests4J_Listener getReporter() {
		return reporter;
	}
	public void setReporter(I_Tests4J_Listener reporter) {
		this.reporter = reporter;
	}
}
