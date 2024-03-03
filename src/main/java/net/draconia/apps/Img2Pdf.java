package net.draconia.apps;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.draconia.apps.img2pdf.ui.Img2PdfWindow;

public class Img2Pdf implements Runnable
{
	private static final Logger logger = LoggerFactory.getLogger(Img2Pdf.class);
	
	public Img2Pdf()
	{ }
	
	public void run()
	{
		try
			{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
		catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException objException)
			{
			logger.error("Problem setting Look & Feel", objException);
			}
		
		new Img2PdfWindow().setVisible(true);
	}
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Img2Pdf());
	}
}
