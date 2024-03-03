package net.draconia.apps.img2pdf.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.draconia.apps.img2pdf.Loader;
import net.draconia.apps.img2pdf.LoaderFactory;
import net.draconia.apps.img2pdf.model.ImageType;

public class LoadAction extends AbstractAction
{
	private static final long serialVersionUID = 8144771590345158431L;
	
	
	private JComboBox<ImageType> mCboImageType = null;
	private JEditorPane mTxtData = null;
	private JPanel mPnlData = null;
	private JTable mTblData = null;
	private JTextField mTxtToLoad = null;
	
	public LoadAction(final JTextField txtToLoad, final JComboBox<ImageType> cboImageType, final JPanel pnlData, final JTable tblData, final JEditorPane txtData)
	{
		super("Load");
		
		putValue(MNEMONIC_KEY, KeyEvent.VK_L);
		putValue(LONG_DESCRIPTION, "Loads Image and Parses the Text out");
		putValue(SHORT_DESCRIPTION, "Loads Image and Parses the Text out");

		setDataField(txtData);
		setDataPanel(pnlData);
		setDataTable(tblData);
		setToLoadField(txtToLoad);
		setTypeComboBox(cboImageType);
	}
	
	public void actionPerformed(final ActionEvent objEvent)
	{
		File fileToLoad = new File(getToLoadField().getText());
		ImageType eImageType = (ImageType)(getTypeComboBox().getSelectedItem());
		Loader objLoader = null;
		LoaderFactory objFactory = new LoaderFactory(getTypeComboBox(), getDataPanel(), getDataField(), getDataTable());
		
		switch(eImageType)
			{
			case TABLE:
				objLoader = objFactory.createTableLoader();
				break;
			case TEXT:
				objLoader = objFactory.createTextLoader();
				break;
			default:
				objLoader = objFactory.createImageLoader();
				break;
			}
		
		objLoader.load(fileToLoad);
	}
	
	protected JEditorPane getDataField()
	{
		return(mTxtData);
	}
	
	protected JPanel getDataPanel()
	{
		return(mPnlData);
	}
	
	protected JTable getDataTable()
	{
		return(mTblData);
	}
	
	protected JComboBox<ImageType> getTypeComboBox()
	{
		return(mCboImageType);
	}
	
	protected void setDataField(final JEditorPane txtData)
	{
		mTxtData = txtData;
	}
	
	protected void setDataPanel(final JPanel pnlData)
	{
		mPnlData = pnlData;
	}
	
	protected void setDataTable(final JTable tblData)
	{
		mTblData = tblData;
	}
	
	protected JTextField getToLoadField()
	{
		return(mTxtToLoad);
	}
	
	protected void setToLoadField(final JTextField txtToLoad)
	{
		mTxtToLoad = txtToLoad;
	}
	
	protected void setTypeComboBox(final JComboBox<ImageType> cboImageType)
	{
		mCboImageType = cboImageType;
	}
}