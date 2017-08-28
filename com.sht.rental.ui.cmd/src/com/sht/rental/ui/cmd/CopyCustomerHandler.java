package com.sht.rental.ui.cmd;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;

public class CopyCustomerHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	 	Clipboard clipboard = new Clipboard(Display.getCurrent());
	 	Customer customer = null;
	 	ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			if (selected instanceof Customer) customer = (Customer) selected;
		}

		if (customer != null) {
			String textData = customer.getDisplayName();
			String rtfData = "{\\rtf1\\b\\i " + textData + "}";
			TextTransfer textTransfer = TextTransfer.getInstance();
			RTFTransfer rtfTransfer = RTFTransfer.getInstance();
			Transfer[] transfers = new Transfer[]{textTransfer, rtfTransfer};
			Object[] data = new Object[]{textData, rtfData};
			clipboard.setContents(data, transfers);
		}
		clipboard.dispose();
		return null;
	}

}
