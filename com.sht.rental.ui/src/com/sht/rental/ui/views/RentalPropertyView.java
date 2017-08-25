package com.sht.rental.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sht.rental.core.RentalCoreActivator;

public class RentalPropertyView extends ViewPart implements ISelectionListener {
	
	private Label rentedObjectLabel;
	private Label customerName;
	private Rental rentalObject;
	private Label lblCustomername;
	private Label lblDatedeb;
	private Label lblDatefin;

	public RentalPropertyView() {
		rentalObject = null;
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		infoGroup.setText("Informations");
		infoGroup.setLayout(new GridLayout(2, false));
		
		rentedObjectLabel = new Label(infoGroup, SWT.NONE);
		rentedObjectLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel.setLayoutData(gd);
		//new Label(infoGroup, SWT.NONE);
		
		Label lblLou = new Label(infoGroup, SWT.NONE);
		lblLou.setText("Lou\u00E9 \u00E0");
		
		lblCustomername = new Label(infoGroup, SWT.NONE);
		lblCustomername.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group grpDates = new Group(parent, SWT.NONE);
		grpDates.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpDates.setText("Dates");
		grpDates.setLayout(new GridLayout(2, false));
		
		Label lblDd = new Label(grpDates, SWT.NONE);
		lblDd.setText("du:");
		
		lblDatedeb = new Label(grpDates, SWT.NONE);
		lblDatedeb.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblDatedeb.setText("");
		
		Label lblAu = new Label(grpDates, SWT.NONE);
		lblAu.setText("au:");
		
		lblDatefin = new Label(grpDates, SWT.NONE);
		
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
	}

	private void setRental(Rental r) {
		rentedObjectLabel.setText(r.getRentedObject().getName());
		lblCustomername.setText(r.getCustomer().getDisplayName());
		lblDatedeb.setText(r.getStartDate().toString());
		lblDatefin.setText(r.getEndDate().toString());
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			if (selected instanceof Rental) setRental((Rental) selected);
		}
		
	}

	@Override
	public void init(IViewSite site) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site);
		site.getPage().addSelectionListener(this);
	}

	@Override
	public void dispose() {
		getSite().getPage().removeSelectionListener(this);
		super.dispose();
	}

}
