package com.sht.rental.ui;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class RentalColorsPreference extends FieldEditorPreferencePage implements IWorkbenchPreferencePage, RentalConstants {

	public RentalColorsPreference() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
		setDescription("Rental Colors preferences");
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		addField(new ColorFieldEditor(PREF_COLOR_CUSTOMER, "Customer", getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_COLOR_RENTAL, "Rental", getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_COLOR_OBJECT, "Objects", getFieldEditorParent()));

	}

}
