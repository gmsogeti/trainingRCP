package com.sht.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;

public class RentalProvider extends LabelProvider implements ITreeContentProvider, IColorProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection<?>) return ((Collection) inputElement).toArray();
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] childrens = null;
		if (parentElement instanceof RentalAgency) {
			childrens = new Node[] {
					new Node(Node.CUSTOMERS, (RentalAgency) parentElement),
					new Node(Node.RENTALS, (RentalAgency) parentElement),
					new Node(Node.RENTAL_OBJECTS, (RentalAgency) parentElement)
			};
		}
		else if (parentElement instanceof Node) {
			childrens = ((Node) parentElement).getChildren();
		}
		return childrens;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		/*if (element instanceof RentalAgency) {
			return ! ((RentalAgency) element).getCustomers().isEmpty();
		}*/
		return true;
	}
	
	@Override
	public String getText(Object element) {
		if (element instanceof RentalAgency) return ((RentalAgency) element).getName();
		if (element instanceof Customer) return ((Customer) element).getDisplayName();
		if (element instanceof RentalObject) return ((RentalObject) element).getName();
		return super.getText(element);
	}
	
	private class Node {
		static final String CUSTOMERS = "Clients";
		static final String RENTALS = "Locations";
		static final String RENTAL_OBJECTS = "Objets à louer";
		
		String label;
		RentalAgency agency;
		
		public Node(String label, RentalAgency agency) {
			super();
			this.label = label;
			this.agency = agency;
		}
		
		public Object[] getChildren() {
			if (label == Node.CUSTOMERS) return agency.getCustomers().toArray();
			if (label == Node.RENTAL_OBJECTS) return agency.getObjectsToRent().toArray();
			if (label == Node.RENTALS) return agency.getRentals().toArray();
			return null;
		}
		
		@Override
		public String toString() {
			return label;
		}
	}

	@Override
	public Color getForeground(Object element) {
		//if (element instanceof RentalAgency) return ((RentalAgency) element).getName();
		if (element instanceof Customer) return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_CYAN);
		if (element instanceof RentalObject) return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_MAGENTA);
		if (element instanceof Rental) return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED);
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}
