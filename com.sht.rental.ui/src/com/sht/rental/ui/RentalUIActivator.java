package com.sht.rental.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUIActivator extends AbstractUIPlugin implements RentalConstants {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sht.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUIActivator plugin;
	
	/**
	 * The constructor
	 */
	public RentalUIActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUIActivator getDefault() {
		return plugin;
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		Bundle b = FrameworkUtil.getBundle(this.getClass());
		
		reg.put(IMG_AGENCIES, ImageDescriptor.createFromURL(b.getEntry(IMG_AGENCIES)));
		reg.put(IMG_RENTALS, ImageDescriptor.createFromURL(b.getEntry(IMG_RENTALS)));
		reg.put(IMG_OBJECT, ImageDescriptor.createFromURL(b.getEntry(IMG_OBJECT)));
		reg.put(IMG_CUSTOMERS, ImageDescriptor.createFromURL(b.getEntry(IMG_CUSTOMERS)));
	}


}
