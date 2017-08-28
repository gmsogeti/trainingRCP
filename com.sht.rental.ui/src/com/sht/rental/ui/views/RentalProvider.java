package com.sht.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sht.rental.ui.RentalConstants;
import com.sht.rental.ui.RentalUIActivator;

public class RentalProvider extends LabelProvider implements ITreeContentProvider, IColorProvider, RentalConstants {

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
	
	@Override
	public Image getImage(Object element) {
		Image img = super.getImage(element);
		String key = "";
		if (element instanceof Customer) key = IMG_CUSTOMERS;
		else if (element instanceof Rental) key = IMG_RENTALS;
		else if (element instanceof RentalObject) key = IMG_OBJECT;
		else if (element instanceof RentalAgency) key = IMG_AGENCIES;
		img = RentalUIActivator.getDefault().getImageRegistry().get(key);
		return img;
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
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((agency == null) ? 0 : agency.hashCode());
			result = prime * result + ((label == null) ? 0 : label.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (agency == null) {
				if (other.agency != null)
					return false;
			} else if (!agency.equals(other.agency))
				return false;
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return label;
		}

		private RentalProvider getOuterType() {
			return RentalProvider.this;
		}
	}

	@Override
	public Color getForeground(Object element) {
		//if (element instanceof RentalAgency) return ((RentalAgency) element).getName();
		Color colElement = Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
		String key = null;
		if (element instanceof Customer) key = PREF_COLOR_CUSTOMER;
		if (element instanceof RentalObject) key = PREF_COLOR_OBJECT;
		if (element instanceof Rental) key = PREF_COLOR_RENTAL;
		
		if (key != null)
			colElement = getAColor(RentalUIActivator.getDefault().getPreferenceStore().getString(key));
		
		return colElement;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	private Color getAColor(String rgbKey) {
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		
		Color col = colorRegistry.get(rgbKey);
		if (col == null) {
			colorRegistry.put(rgbKey, StringConverter.asRGB(rgbKey));
			col = colorRegistry.get(rgbKey);
		}
		return col;
	}
}
