package net.draconia.apps.img2pdf;

import java.io.File;
import java.io.Serializable;

import javax.swing.JEditorPane;

public class TextLoader implements Loader, Serializable
{
	private static final long serialVersionUID = 2333256270999695685L;

	private JEditorPane mTxtData = null;
	
	public TextLoader(final JEditorPane txtData)
	{ }
	
	protected JEditorPane getDataField()
	{
		return(mTxtData);
	}
	
	public void load(final File fileToLoad)
	{
		
	}
	
	protected void setDataField(final JEditorPane txtData)
	{
		mTxtData = txtData;
	}
}