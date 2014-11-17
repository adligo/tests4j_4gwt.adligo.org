package org.adligo.tests4j_4gwt.client.presenter;

import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.results.I_PhaseState;
import org.adligo.tests4j.models.shared.results.I_TrialResult;
import org.adligo.tests4j.models.shared.results.I_TrialRunResult;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Listener;
import org.adligo.tests4j.system.shared.api.I_Tests4J_Params;
import org.adligo.tests4j.system.shared.report.summary.SummaryReporter;
import org.adligo.tests4j_4gwt.client.model.run.GwtTests4J_Params;
import org.adligo.tests4j_4gwt.client.model.run.GwtTests4J_Processor;
import org.adligo.tests4j_4gwt.client.ui.I_ConsoleUi;
import org.adligo.tests4j_4gwt.client.ui.I_RunHandler;
import org.adligo.tests4j_4gwt.client.ui.I_TrialRunUi;

public class TrialRunPresenter implements I_RunHandler, I_Tests4J_Listener {
	private GwtTests4J_Params params;
	private I_TrialRunUi ui;
	private I_ConsoleUi console;
	private ConsolePresenter consolePresenter = new ConsolePresenter();
	private SummaryReporter summaryReporter;
	private GwtTests4J_Processor processor = new GwtTests4J_Processor();
	
	public TrialRunPresenter() {
		processor.setReporter(this);
		processor.setLog(consolePresenter);
	}
	public void setParams(GwtTests4J_Params p) {
		params = p;
	}

	@Override
	public void run() {
		consolePresenter.clear();
		consolePresenter.setBufferSize(ui.getLineBufferSetting());
		
		ui.clearResults();
		processor.run(params);
	}

	public I_TrialRunUi getUi() {
		return ui;
	}

	public void setUi(I_TrialRunUi ui) {
		this.ui = ui;
		console = ui.getConsole();
		ui.setRunHandler(this);
		consolePresenter.setUi(console);
		summaryReporter = new SummaryReporter(consolePresenter);
	}

	@Override
	public void onMetadataCalculated(I_TrialRunMetadata metadata) {
		summaryReporter.onMetadataCalculated(metadata);
		long tests = metadata.getAllTestsCount();
		ui.setTotalTests(tests);
	}

	@Override
	public void onStartingTrial(String trialName) {
		summaryReporter.onStartingTrial(trialName);
		ui.addTrial(trialName);
	}

	@Override
	public void onStartingTest(String trialName, String testName) {
		summaryReporter.onStartingTest(trialName, testName);
	}

	@Override
	public void onTestCompleted(String trialName, String testName,
			boolean passed) {
		summaryReporter.onTestCompleted(trialName, testName, passed);
		ui.addTest(trialName, testName, passed);
	}

	@Override
	public void onTrialCompleted(I_TrialResult result) {
		summaryReporter.onTrialCompleted(result);
	}

	@Override
	public void onRunCompleted(I_TrialRunResult result) {
		summaryReporter.onRunCompleted(result);
	}

	@Override
	public void onProccessStateChange(I_PhaseState info) {
		summaryReporter.onProccessStateChange(info);
	}
	@Override
	public void onProgress(I_PhaseState info) {
		// TODO Auto-generated method stub
		
	}
  @Override
  public void onStartingSetup(I_Tests4J_Params params) {
    // TODO Auto-generated method stub
    
  }
}
