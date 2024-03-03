package net.draconia.apps.img2pdf;

import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.draconia.apps.img2pdf.model.ImageType;

public class PDFWriter implements Serializable
{
	private static Logger logger = LoggerFactory.getLogger(PDFWriter.class);
	private static final long serialVersionUID = 2936102323820372682L;
	
	private JComboBox<ImageType> mCboType = null;
	private JEditorPane mTxtData = null;
	private JPanel mPnlData = null;
	private JTable mTblData = null;
	private JTextField mTxtToWrite = null;
	
	public PDFWriter(final JTextField txtToWrite, final JComboBox<ImageType> cboType, final JPanel pnlImageData, final JTable tblData, final JEditorPane txtData)
	{
		setDataTable(tblData);
		setDataField(txtData);
		setImageDataPanel(pnlImageData);
		setToWriteField(txtToWrite);
		setTypeField(cboType);
	}
	
	protected JTable getDataTable()
	{
		return(mTblData);
	}
	
	protected JTable getDataField()
	{
		return(mTblData);
	}
	
	protected JPanel getImageDataPanel()
	{
		return(mPnlData);
	}
	
	protected JTextField getToWriteField()
	{
		return(mTxtToWrite);
	}
	
	protected JComboBox<ImageData> getTypeField()
	{
		return(mCboType);
	}
	
	protected void setDataTable(final JTable tblData)
	{
		mTblData = tblData;
	}
	
	protected void setDataField(final JEditorPane txtData)
	{
		mTxtData = txtData;
	}
	
	protected void setImageDataPanel(final JPanel pnlImageData)
	{
		mPnlData = pnlImageData;
	}
	
	protected void setToWriteField(final JTextField txtToWrite)
	{
		mTxtToWrite = txtToWrite;
	}
	
	protected void setTypeField(final JComboBox<ImageType> cboType)
	{
		mCboType = cboType;
	}
	
	public void write()
	{
		
	}
}