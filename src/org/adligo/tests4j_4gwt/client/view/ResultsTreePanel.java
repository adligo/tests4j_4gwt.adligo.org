package org.adligo.tests4j_4gwt.client.view;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class ResultsTreePanel extends Composite {
	private Map<String,TreeItem> trials = new HashMap<String,TreeItem>();
	private TreeItem top;
	private Tree tree;
	
	public ResultsTreePanel() {
		
		tree = new Tree();
		initWidget(tree);
		
		top = new TreeItem();
		top.setText("Results;");
		top.setState(true);
		tree.addItem(top);
	}

	public void addTrial(String name) {
		TreeItem trialItem = new TreeItem();
		trialItem.setText(name);
		top.addItem(trialItem);
		top.setState(true, true);
		trials.put(name, trialItem);
		
	}
	
	public void clear() {
		top.removeItems();
		trials.clear();
	}
	
	public void addTest(String trialName, String testName, boolean passed) {
		TreeItem trialItem = trials.get(trialName);
		if (passed) {
			trialItem.setStyleName("greenText");
		} else {
			trialItem.setStyleName("redText");
			trialItem.setState(true, true);
		}
		TreeItem testItem = new TreeItem();
		testItem.setText(testName);
		if (passed) {
			testItem.setStyleName("greenText");
		} else {
			testItem.setStyleName("redText");
		}
		trialItem.addItem(testItem);
	}
}
