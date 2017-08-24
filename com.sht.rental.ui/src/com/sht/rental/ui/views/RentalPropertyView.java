package com.sht.rental.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sht.rental.core.RentalCoreActivator;

public class RentalPropertyView extends ViewPart {
	
	private Label rentedObjectLabel;
	private Label customerName;
	private Rental rentalObject;

	public RentalPropertyView() {
		rentalObject = null;
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setText("Informations");
		
		rentedObjectLabel = new Label(infoGroup, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel.setLayoutData(gd);
		
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
	}

	private void setRental(Rental r) {
		rentedObjectLabel.setText(r.getRentedObject().getName());
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
