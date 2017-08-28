package com.sht.rental.ui;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class RentalPerspective implements IPerspectiveFactory {
	
	public static final String ID = "com.sht.rental.ui.perspective1";

	/**
	 * Creates the initial layout for a page.
	 */
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		String editorArea = layout.getEditorArea();
		
		layout.addView("com.sht.rental.ui.views.AgencyView", IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("com.sht.rental.ui.RentalPropertyView", IPageLayout.RIGHT, 0.5f, "com.sht.rental.ui.views.AgencyView");
		layout.addView("com.sht.rental.ui.CustomerPropertyrView", IPageLayout.BOTTOM, 0.5f, "com.sht.rental.ui.RentalPropertyView");
		}


}
