package org.adligo.tests4j_4gwt.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class ProgressPanel extends Composite {
	private FlexTable flexTable;
	private HorizontalPanel progressPanel;
	private int total;
	private SimplePanel passedPanel;
	private SimplePanel failedPanel;
	private String widthString;
	private int passed;
	private int failed;
	
	public ProgressPanel() {
		
		flexTable = new FlexTable();
		flexTable.setStyleName("grey");
		initWidget(flexTable);
		flexTable.setSize("100%", "30px");
		
		progressPanel = new HorizontalPanel();
		progressPanel.setStyleName("white");
		progressPanel.setSize("98%", "18px");
		flexTable.setWidget(0, 0, progressPanel);
		
		
		flexTable.getCellFormatter().setHeight(0, 0, "20px");
		flexTable.getCellFormatter().setWidth(0, 0, "98%");
		flexTable.getCellFormatter().setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);
		flexTable.getCellFormatter().setVerticalAlignment(0, 0, HasVerticalAlignment.ALIGN_MIDDLE);
		
	}

	public void setTotal(int p) {
		total = p;
		passed = 0;
		failed = 0;
		calcProgressSegmentSize();
		progressPanel.clear();
		passedPanel = new SimplePanel();
		passedPanel.setStyleName("green");
		passedPanel.setHeight("18px");
		
		failedPanel = new SimplePanel();
		failedPanel.setStyleName("red");
		failedPanel.setHeight("18px");
	}
	
	public void resize(Integer width, Integer height) {
		if (width != null) {
			int newWidth = width;
			flexTable.setWidth("" + newWidth + "px");
			float newProgWidthFloat = newWidth;
			newProgWidthFloat = newProgWidthFloat * (float) 0.98;
			int newProgWidth = Math.round(newProgWidthFloat);
			
			String newInnerWidth = "" + newProgWidth + "px";
			progressPanel.setWidth(newInnerWidth);
			flexTable.getCellFormatter().setWidth(0, 0, newInnerWidth);
		}
		calcProgressSegmentSize();
	}

	private void calcProgressSegmentSize() {
		if (passedPanel != null) {
			float totalPix = progressPanel.getOffsetWidth();
			
			float totalTests = total;
			float passedPct = passed;
			float failedPct = failed;
			
			passedPct = passedPct / totalTests;
			failedPct = failedPct / totalTests;
			
			float passedPix = totalPix * passedPct;
			float failedPix = totalPix * failedPct;
			
			int passPix = Math.round(passedPix);
			int failPix = Math.round(failedPix);
			
			passedPanel.setWidth("" + passPix  + "px");
			failedPanel.setWidth("" + failPix  + "px");
		}
	}
	
	public void addProgress(boolean p) {
		if (p) {
			passed++;
			if (progressPanel.getWidgetIndex(passedPanel) == -1) {
				progressPanel.add(passedPanel);
			}
		} else {
			failed++;
			if (progressPanel.getWidgetIndex(failedPanel) == -1) {
				progressPanel.add(failedPanel);
			}
		}
		calcProgressSegmentSize();
	}

}
