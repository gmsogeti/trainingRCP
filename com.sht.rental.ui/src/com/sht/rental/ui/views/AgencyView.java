package com.sht.rental.ui.views;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sht.rental.core.RentalCoreActivator;

import org.eclipse.swt.widgets.Tree;

import java.util.ArrayList;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;

public class AgencyView extends ViewPart implements IViewPart {
	public AgencyView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		
		TreeViewer treeViewer = new TreeViewer(parent);
		Tree agencyTree = treeViewer.getTree();
		ArrayList<RentalAgency> agencies = new ArrayList<RentalAgency>();
		agencies.add(RentalCoreActivator.getAgency());
		
		RentalProvider provider = new RentalProvider();
		treeViewer.setContentProvider(provider);
		treeViewer.setLabelProvider(provider);
		treeViewer.setInput(agencies);
		
		treeViewer.expandAll();
		
		getSite().setSelectionProvider(treeViewer);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
