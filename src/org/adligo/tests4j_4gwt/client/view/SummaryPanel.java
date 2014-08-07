package org.adligo.tests4j_4gwt.client.view;

import org.adligo.tests4j_4gwt.client.ui.I_RunHandler;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.core.client.GWT;

public class SummaryPanel extends Composite {
	private static final AppConstants CONSTANTS = GWT.create(AppConstants.class);
	private ProgressPanel progressBar;
	private TextBox intel4jUrlTextBox;
	private TextBox buildIdTextBox;
	private IntegerBox lineBufferTextBox;
	private Button runButton;
	private I_RunHandler runHandler;
	
	public SummaryPanel() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("lightGrey");
		initWidget(verticalPanel);
		verticalPanel.setWidth("100%");
		verticalPanel.setHeight("100px");
		
		progressBar = new ProgressPanel();
		verticalPanel.add(progressBar);
		progressBar.setSize("100%", "20");
		
		FlexTable flexTable = new FlexTable();
		verticalPanel.add(flexTable);
		flexTable.setSize("100%", "40");
		
		Label intel4JUrlLabel = new Label(CONSTANTS.intel4JUrlLabel_text());
		flexTable.setWidget(0, 0, intel4JUrlLabel);
		flexTable.getCellFormatter().setWidth(0, 0, "130px");
		flexTable.getCellFormatter().setHeight(0, 0, "20px");
		
		intel4jUrlTextBox = new TextBox();
		intel4jUrlTextBox.setMaxLength(3000);
		intel4jUrlTextBox.setEnabled(false);
		flexTable.setWidget(0, 1, intel4jUrlTextBox);
		flexTable.getCellFormatter().setHeight(0, 1, "20");
		intel4jUrlTextBox.setReadOnly(true);
		intel4jUrlTextBox.setSize("90%", "18px");
		
		Label buildIdLabel = new Label(CONSTANTS.buildIdLabel_text());
		flexTable.setWidget(1, 0, buildIdLabel);
		flexTable.getCellFormatter().setHeight(1, 0, "20px");
		
		buildIdTextBox = new TextBox();
		flexTable.setWidget(1, 1, buildIdTextBox);
		buildIdTextBox.setSize("90%", "18px");
		flexTable.getCellFormatter().setHeight(1, 1, "18px");
		
		Label consoleLinesBufferLabel = new Label(CONSTANTS.consoleLinesBufferLabel_text());
		flexTable.setWidget(2, 0, consoleLinesBufferLabel);
		flexTable.getCellFormatter().setHeight(2, 0, "20px");
		flexTable.getCellFormatter().setWidth(2, 0, "130");
		consoleLinesBufferLabel.setWordWrap(false);
		
		lineBufferTextBox = new IntegerBox();
		flexTable.setWidget(2, 1, lineBufferTextBox);
		lineBufferTextBox.setHeight("20px");
		
		runButton = new Button(CONSTANTS.runButton_html());
		runButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				onRun();
			}
		});
		flexTable.setWidget(2, 2, runButton);
		flexTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		flexTable.getFlexCellFormatter().setColSpan(0, 1, 2);
		flexTable.getCellFormatter().setVerticalAlignment(2, 2, HasVerticalAlignment.ALIGN_MIDDLE);
		flexTable.getCellFormatter().setHorizontalAlignment(2, 2, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getCellFormatter().setHorizontalAlignment(2, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		flexTable.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		flexTable.getCellFormatter().setHorizontalAlignment(1, 0, HasHorizontalAlignment.ALIGN_RIGHT);
		flexTable.getFlexCellFormatter().setColSpan(1, 1, 2);
	}
	
	public void onRun() {
		runButton.setEnabled(false);
	}

	public I_RunHandler getRunHandler() {
		return runHandler;
	}

	public void setRunHandler(I_RunHandler runHandler) {
		this.runHandler = runHandler;
	}
}
