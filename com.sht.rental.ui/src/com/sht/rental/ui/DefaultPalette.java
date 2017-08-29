package com.sht.rental.ui;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalObject;

public class DefaultPalette implements IColorProvider, RentalConstants {

	public DefaultPalette() {
		// TODO Auto-generated constructor stub
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
