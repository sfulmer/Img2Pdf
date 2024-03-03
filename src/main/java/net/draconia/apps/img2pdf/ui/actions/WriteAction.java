package net.draconia.apps.img2pdf.ui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.draconia.apps.img2pdf.PDFWriter;

import net.draconia.apps.img2pdf.model.ImageType;

public class WriteAction extends AbstractAction
{
	private static final long serialVersionUID = -8478183876022207781L;
	
	private JComboBox<ImageType> mCboType = null;
	private JEditorPane mTxtData = null;
	private JPanel mPnlData = null;
	private JTable mTblData = null;
	private JTextField mTxtOutputFile = null;
	
	public WriteAction(final JTextField txtOutput, final JComboBox<ImageType> cboType, final JPanel pnlData, final JTable tblData, final JEditorPane txtData)
	{
		super("Write File");
		
		putValue(LONG_DESCRIPTION, "Writes the data from the File to the file system");
		putValue(MNEMONIC_KEY, KeyEvent.VK_W);
		putValue(SHORT_DESCRIPTION, "Writes the data from the File to the file system");
		
		setDataField(txtData);
		setDataTable(tblData);
		setImageDataPanel(pnlData);
		setOutputFileField(txtOutput);
		setTypeComboBox(cboType);
	}
	
	public void actionPerformed(final ActionEvent objEvent)
	{
		// final JTextField txtToWrite, final JComboBox<ImageType> cboType, final JPanel pnlImageData, final JTable tblData, final JEditorPane txtData
		JTextField txtToWrite = getOutputFileField();
		JComboBox<ImageType> cboType = getTypeComboBox();
		JPanel pnlImageData = getImageDataPanel();
		JTable tblData = getDataTable();
		JEditorPane txtData = getDataField();
		
		PDFWriter writer = new PDFWriter(txtToWrite, cboType, pnlImageData, tblData, txtData);
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
		return(mPnlData);
	}
	
	protected JTextField getOutputFileField()
	{
		return(mTxtOutputFile);
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
	
	protected void setImageDataPanel(final JPanel pnlData)
	{
		mPnlData = pnlData;
	}
	
	protected void setOutputFileField(final JTextField txtOutputFile)
	{
		mTxtOutputFile = txtOutputFile;
	}
	
	protected void setTypeComboBox(final JComboBox<ImageType> cboType)
	{
		mCboType = cboType;
	}
}