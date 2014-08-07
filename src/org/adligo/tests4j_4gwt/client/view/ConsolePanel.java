package org.adligo.tests4j_4gwt.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ConsolePanel extends Composite {
	public ConsolePanel() {
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setAlwaysShowScrollBars(true);
		initWidget(scrollPanel);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		scrollPanel.setWidget(verticalPanel);
		
	}

}
