package net.draconia.apps.img2pdf.ui.actions;

import java.awt.Component;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import net.draconia.apps.img2pdf.ui.ControlFactory;

public class BrowseAction extends AbstractAction
{
	private static final long serialVersionUID = 2167632823146151892L;
	
	private Map<String, List<String>> mMapFilters = null;
	private JTextField mTxtFilename = null;
	
	public BrowseAction(final JTextField txtFilename, final Map<String, List<String>> mapFilters)
	{
		super("Browse...");
		
		putValue(MNEMONIC_KEY, KeyEvent.VK_B);
		putValue(LONG_DESCRIPTION, "Browses for a File");
		
		setFilters(mapFilters);
		setFilenameField(txtFilename);
	}
	
	public void actionPerformed(final ActionEvent objEvent)
	{
		JFileChooser dlg = new ControlFactory().getFileChooser(getFilters());
		
		if(dlg.showOpenDialog((Component)(getFilenameField().getParent())) == JFileChooser.APPROVE_OPTION)
			getFilenameField().setText(dlg.getSelectedFile().getAbsolutePath());
	}
	
	protected Map<String, List<String>> getFilters()
	{
		return(mMapFilters);
	}
	
	protected JTextField getFilenameField()
	{
		return(mTxtFilename);
	}
	
	protected void setFilters(final Map<String, List<String>> mapFilters)
	{
		mMapFilters = mapFilters;
	}
	
	protected void setFilenameField(final JTextField txtFilename)
	{
		mTxtFilename = txtFilename;
	}
}