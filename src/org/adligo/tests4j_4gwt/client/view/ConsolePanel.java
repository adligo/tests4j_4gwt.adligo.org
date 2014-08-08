package org.adligo.tests4j_4gwt.client.view;

import java.util.ArrayList;
import java.util.List;

import org.adligo.tests4j_4gwt.client.ui.I_ConsoleUi;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextArea;

public class ConsolePanel extends Composite implements I_ConsoleUi {
	private TextArea console;
	private List<String> messages = new ArrayList<String>();
	
	public ConsolePanel() {
		
		console = new TextArea();
		console.setSize("100%", "100%");
		initWidget(console);

		
	}

	@Override
	public void log(String p, boolean removeTop) {
		if (removeTop) {
			messages.remove(0);
		}
		messages.add(p);
		StringBuilder sb = new StringBuilder();
		boolean first = false;
		for (String message: messages) {
			if (!first) {
				sb.append("\n");
			}
			sb.append(message);
			first = false;
		}
		console.setText(sb.toString());
	}

	@Override
	public void clear() {
		messages.clear();
		console.setText("");
	}

}
