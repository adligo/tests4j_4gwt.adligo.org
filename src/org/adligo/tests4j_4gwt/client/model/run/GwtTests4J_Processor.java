package org.adligo.tests4j_4gwt.client.model.run;

import java.util.List;

import org.adligo.tests4j.models.shared.asserts.uniform.EvaluatorLookup;
import org.adligo.tests4j.models.shared.asserts.uniform.I_EvaluatorLookup;
import org.adligo.tests4j.models.shared.common.I_Platform;
import org.adligo.tests4j.models.shared.common.Platform;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.system.I_Tests4J_AssertListener;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Listener;
import org.adligo.tests4j.models.shared.system.I_Tests4J_Log;
import org.adligo.tests4j.models.shared.trials.I_Trial;
import org.adligo.tests4j.models.shared.trials.I_TrialBindings;
import org.adligo.tests4j.shared.report.summary.SummaryReporter;

public class GwtTests4J_Processor implements I_TrialBindings {
	private GwtTests4J_AssertListener assertListener = new GwtTests4J_AssertListener();
	private I_EvaluatorLookup evaluatorLookup = EvaluatorLookup.DEFAULT_LOOKUP;
	private GwtTests4J_TrialRunner runner = new GwtTests4J_TrialRunner();
	private I_Tests4J_Listener reporter;
	private I_Tests4J_Log log;
	
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
		runner.setListener(reporter);
		
		calculateMetadata(params);
		
		List<I_GwtTrialWrapper> wrappers = params.getTrials();
		for (I_GwtTrialWrapper wrap: wrappers) {
			I_Trial trial = wrap.getTrial();
			trial.setBindings(this);
			runner.setTrial(trial, wrap);
			runner.run();
		}
		assertListener.finishTrial();
	}
	private void calculateMetadata(GwtTests4J_Params params) {
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
		
		reporter.onMetadataCalculated(new TrialRunMetadata(trmm));
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
