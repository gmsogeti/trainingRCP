package com.sht.rental.ui;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class RedPalette implements IColorProvider {

	public RedPalette() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getForeground(Object element) {
		return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
	}

	@Override
	public Color getBackground(Object element) {
		return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY);
	}

}
