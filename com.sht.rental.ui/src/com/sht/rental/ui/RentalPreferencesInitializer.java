package com.sht.rental.ui;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;

public class RentalPreferencesInitializer extends AbstractPreferenceInitializer implements RentalConstants{

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore prefStore = RentalUIActivator.getDefault().getPreferenceStore();
		
		prefStore.setDefault(PREF_COLOR_CUSTOMER, StringConverter.asString(new RGB(255, 0, 0)));
		prefStore.setDefault(PREF_COLOR_OBJECT, StringConverter.asString(new RGB(0, 255, 0)));
		prefStore.setDefault(PREF_COLOR_RENTAL, StringConverter.asString(new RGB(0, 0, 255)));

	}

}
