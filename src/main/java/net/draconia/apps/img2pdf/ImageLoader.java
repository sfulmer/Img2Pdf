package net.draconia.apps.img2pdf;

import java.io.File;
import java.io.Serializable;

import javax.swing.JPanel;

public class ImageLoader implements Loader, Serializable
{
	private static final long serialVersionUID = 2333256270999695685L;

	private JPanel mPnlImageData = null;
	
	public ImageLoader(final JPanel pnlImageData)
	{
		setImageDataPanel(pnlImageData);
	}
	
	protected JPanel getImageDataPanel()
	{
		return(mPnlImageData);
	}
	
	public void load(final File fileToLoad)
	{
		
	}
	
	protected void setImageDataPanel(final JPanel pnlImageData)
	{
		mPnlImageData = pnlImageData;
	}
}