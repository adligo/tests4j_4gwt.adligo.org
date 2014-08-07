package org.adligo.tests4j_4gwt.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class ProgressPanel extends Composite {
	public ProgressPanel() {
		
		FlexTable flexTable = new FlexTable();
		flexTable.setStyleName("grey");
		initWidget(flexTable);
		flexTable.setSize("100%", "30px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("white");
		flexTable.setWidget(0, 0, horizontalPanel);
		horizontalPanel.setSize("98%", "18px");
		
		SimplePanel simplePanel = new SimplePanel();
		simplePanel.setStyleName("red");
		horizontalPanel.add(simplePanel);
		horizontalPanel.setCellWidth(simplePanel, "10px");
		simplePanel.setSize("10px", "18px");
		
		SimplePanel simplePanel_1 = new SimplePanel();
		simplePanel_1.setStyleName("green");
		horizontalPanel.add(simplePanel_1);
		simplePanel_1.setSize("10px", "18px");
		flexTable.getCellFormatter().setHeight(0, 0, "20px");
		flexTable.getCellFormatter().setWidth(0, 0, "98%");
		flexTable.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		
		addGreen();
		
		addRed();
	}

	private void addRed() {
	}
	private void addGreen() {
	}

}
