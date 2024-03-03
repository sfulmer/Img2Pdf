package net.draconia.apps.img2pdf.ui;

import java.awt.BorderLayout;
import java.awt.HeadlessException;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import net.draconia.apps.img2pdf.ui.actions.ExitAction;

public class Img2PdfWindow extends JFrame
{
	private static final long serialVersionUID = 123456789L;
	
	private Img2PdfMainPanel mPnlMain = null;
	
	public Img2PdfWindow() throws HeadlessException
	{
		super("Image To PDF");
	}
	
	protected Img2PdfMainPanel getMainPanel()
	{
		if(mPnlMain == null)
			mPnlMain = new Img2PdfMainPanel();
		
		return(mPnlMain);
	}
	
	private void initControls()
	{
		setLayout(new BorderLayout(5, 5));
		
		add(getMainPanel(), BorderLayout.CENTER);
		
		pack();
	}
	
	private void initMenus()
	{
		JMenu mnuFile = new JMenu("&File");
		JMenuBar mnuBar = new JMenuBar();
		
		mnuFile.add(new ExitAction(this));
		
		mnuBar.add(mnuFile);
		
		setJMenuBar(mnuBar);
	}
	
	@PostConstruct
	private void initWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		initMenus();
		initControls();
	}
}
