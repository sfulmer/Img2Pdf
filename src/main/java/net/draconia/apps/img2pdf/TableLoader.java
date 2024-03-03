package net.draconia.apps.img2pdf;

import java.io.File;
import java.io.Serializable;

import javax.swing.JTable;

public class TableLoader implements Loader, Serializable
{
	private static final long serialVersionUID = 2333256270999695685L;

	private JTable mTblData = null;
	
	public TableLoader(final JTable tblData)
	{ }
	
	protected JTable getDataField()
	{
		return(mTblData);
	}
	
	public void load(final File fileToLoad)
	{
		
	}
	
	protected void setDataField(final JTable tblData)
	{
		mTblData = tblData;
	}
}