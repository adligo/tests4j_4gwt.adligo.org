package org.adligo.tests4j_4gwt.client.view;

import org.adligo.tests4j_4gwt.client.ui.I_RunHandler;
import org.adligo.tests4j_4gwt.client.ui.I_TrialRunUi;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.TextArea;

public class TrialRunView extends Composite implements I_TrialRunUi {
	private static final AppConstants CONSTANTS = GWT.create(AppConstants.class);
	private SummaryPanel summaryPanel;
	private ConsolePanel consolePanel;
	private ResultsTreePanel resultsPanel;
	private SimplePanel widgetPanel;
	private TabPanel tabPanel;
	private TextArea textArea;
	
	public TrialRunView() {
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		
		Window.addResizeHandler(new ResizeHandler() {
			
			@Override
			public void onResize(ResizeEvent event) {
				resize();
			}
		});
		verticalPanel.setSize("100%", "100%");
		
		summaryPanel = new SummaryPanel();
		summaryPanel.setSize("100%", "100px");
		verticalPanel.add(summaryPanel);
		
		tabPanel = new TabPanel();
		verticalPanel.add(tabPanel);
		verticalPanel.setCellHorizontalAlignment(tabPanel, HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setCellHeight(tabPanel, CONSTANTS.tabPanel_height());
		verticalPanel.setCellWidth(tabPanel, "100%");
		tabPanel.setSize("100%", "300px");
		
		consolePanel = new ConsolePanel();
		tabPanel.add(consolePanel, CONSTANTS.consolePanel_TabText(), false);
		consolePanel.setSize("100%", "300px");
		
		resultsPanel = new ResultsTreePanel();
		tabPanel.add(resultsPanel, CONSTANTS.resultsPanel_TabText(), false);
		resultsPanel.setSize("100%", "300px");
		
		widgetPanel = new SimplePanel();
		tabPanel.add(widgetPanel, CONSTANTS.widgetPanel_TabText(), false);
		widgetPanel.setSize("100%", "300px");
		
		textArea = new TextArea();
		textArea.setText(CONSTANTS.textArea_text() + "\n" + 
				"AppName: " + Window.Navigator.getAppName() + "\n" +
				"AppVersion: " + Window.Navigator.getAppVersion()+ "\n" +
				"AppCodeName: " + Window.Navigator.getAppCodeName() + "\n" +
				"Platform: " + Window.Navigator.getPlatform() + "\n" +
				"UserAgent: " + Window.Navigator.getUserAgent());
		widgetPanel.setWidget(textArea);
		textArea.setSize("100%", "100%");
		tabPanel.selectTab(0);
	}

	@Override
	public void clearResults() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTrial(String trial) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTest(String trial, String test, boolean passed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTrialPassed(boolean passed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showTestWidget(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProgress(double pct, boolean passed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRunHandler(I_RunHandler handler) {
		summaryPanel.setRunHandler(handler);
	}


	@Override
	public void resize() {
		int height = Window.getClientHeight();
		summaryPanel.setHeight("100px");
		int left = height - 100;
		if (left <= 300) {
			tabPanel.setHeight("400px");
			consolePanel.setHeight("300px");
			resultsPanel.setHeight("300px");
			widgetPanel.setHeight("300px");
		} else {
			tabPanel.setHeight("" + left + "px");
			int tabHeight = left - 100;
			consolePanel.setHeight("" + tabHeight + "px");
			resultsPanel.setHeight("" + tabHeight  + "px");
			widgetPanel.setHeight("" + tabHeight + "px");
		}
		tabPanel.selectTab(0);
		
	}
}
