package org.adligo.tests4j_4gwt.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

public class ResultsTreePanel extends Composite {
	public ResultsTreePanel() {
		
		Tree tree = new Tree();
		initWidget(tree);
		
		TreeItem trtmNewItem = new TreeItem();
		trtmNewItem.setText("Results;");
		tree.addItem(trtmNewItem);
	}

}
