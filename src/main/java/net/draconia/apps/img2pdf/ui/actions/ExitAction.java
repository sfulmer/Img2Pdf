package net.draconia.apps.img2pdf.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class ExitAction extends AbstractAction {

	private static final long serialVersionUID = -8251125703007052935L;
	
	private JFrame mWndToExit = null;
	
	public ExitAction(final JFrame wndToExit)
	{
		super("Exit");

		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK, true));
		putValue(LONG_DESCRIPTION, "Exits the Application");
		putValue(MNEMONIC_KEY, KeyEvent.VK_X);
		putValue(SHORT_DESCRIPTION, "Exits the Application");
		
		setToExitWindow(wndToExit);
	}
	
	public void actionPerformed(final ActionEvent objEvent)
	{
		getToExitWindow().dispose();
	}
	
	protected JFrame getToExitWindow()
	{
		return(mWndToExit);
	}
	
	protected void setToExitWindow(final JFrame wndToExit)
	{
		mWndToExit = wndToExit;
	}
}