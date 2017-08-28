                                                             package com.sht.rental.adapters;

import org.eclipse.core.runtime.IAdapterFactory;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;

public class RentalCustomerAdapterFactory implements IAdapterFactory {

	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		T result = null;
		if ((adaptableObject instanceof Rental) && (adapterType == Customer.class)) {
			result = (T) ((Rental)adaptableObject).getCustomer();
		}
		return result;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] {Customer.class};
	}

}
