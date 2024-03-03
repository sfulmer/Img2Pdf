package net.draconia.apps.img2pdf;

import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import net.draconia.apps.img2pdf.model.ImageType;

public class LoaderFactory implements Serializable
{
	private static final long serialVersionUID = 3206967480778264611L;
	
	private JComboBox<ImageType> mCboType = null;
	private JEditorPane mTxtData = null;
	private JPanel mPnlImageData = null;
	private JTable mTblData = null;
	
	public LoaderFactory(final JComboBox<ImageType> cboType, final JPanel pnlImageData, final JEditorPane txtData, final JTable tblData)
	{
		setDataField(txtData);
		setDataTable(tblData);
		setImageDataPanel(pnlImageData);
		setTypeComboBox(cboType);
	}
	
	public Loader createImageLoader()
	{
		return(new ImageLoader(getImageDataPanel()));
	}
	
	public Loader createTableLoader()
	{
		return(new TableLoader(getDataTable()));
	}
	
	public Loader createTextLoader()
	{
		return(new TextLoader(getDataField()));
	}
	
	protected JEditorPane getDataField()
	{
		return(mTxtData);
	}
	
	protected JTable getDataTable()
	{
		return(mTblData);
	}
	
	protected JPanel getImageDataPanel()
	{
		return(mPnlImageData);
	}
	
	protected JComboBox<ImageType> getTypeComboBox()
	{
		return(mCboType);
	}
	
	protected void setDataField(final JEditorPane txtData)
	{
		mTxtData = txtData;
	}
	
	protected void setDataTable(final JTable tblData)
	{
		mTblData = tblData;
	}
	
	protected void setImageDataPanel(final JPanel pnlImageData)
	{
		mPnlImageData = pnlImageData;
	}
	
	protected void setTypeComboBox(final JComboBox<ImageType> cboType)
	{
		mCboType = cboType;
	}
}
