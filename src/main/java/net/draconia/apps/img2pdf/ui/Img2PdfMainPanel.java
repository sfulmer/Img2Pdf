package net.draconia.apps.img2pdf.ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.draconia.apps.img2pdf.model.ImageType;
import net.draconia.apps.img2pdf.ui.actions.BrowseAction;
import net.draconia.apps.img2pdf.ui.actions.LoadAction;

public class Img2PdfMainPanel extends JPanel
{
	private static final long serialVersionUID = -5196785086801049290L;
	
	private JButton mBtnBrowseInput = null, mBtnBrowseOutput = null;
	private JButton mBtnLoadFile = null, mBtnWriteFile = null;
	private JComboBox<ImageType> mCboType = null;
	private JEditorPane mTxtData = null;
	private JLabel mLblInput = null, mLblOutput = null, mLblType = null;
	private JPanel mPnlData = null;
	private JTable mTblData = null;
	private JTextField mTxtInput = null, mTxtOutput = null;
	
	public Img2PdfMainPanel()
	{
		super(new GridBagLayout());
	}
	
	protected JButton getBrowseInputButton()
	{
		if(mBtnBrowseInput == null)
			{
			List<String> lstExts = Collections.synchronizedList(new ArrayList<String>());
			Map<String, List<String>> mapFilters = new TreeMap<String, List<String>>();
			
			lstExts.add("JPG");
			lstExts.add("PNG");
			lstExts.add("GIF");
			
			mapFilters.put("Image Files", lstExts);
			
			mBtnBrowseInput = new ControlFactory().createButton(new BrowseAction(getInputField(), mapFilters));
			}
		
		return(mBtnBrowseInput);
	}
	
	protected JButton getBrowseOutputButton()
	{
		if(mBtnBrowseOutput == null)
			{
			List<String> lstExts = Collections.synchronizedList(new ArrayList<String>());
			Map<String, List<String>> mapFilters = new TreeMap<String, List<String>>();
			
			lstExts.add("PDF");
			
			mapFilters.put("Acrobat Files", lstExts);
			
			mBtnBrowseOutput = new ControlFactory().createButton(new BrowseAction(getOutputField(), mapFilters));
			}
		
		return(mBtnBrowseOutput);
	}
	
	protected JEditorPane getDataField()
	{ }
	
	protected JTable getDataTable()
	{ }
	
	protected JPanel getImageDataPanel()
	{
		if(mPnlData == null)
			mPnlData = new JPanel();
		
		return(mPnlData);
	}
	
	protected JTextField getInputField()
	{
		if(mTxtInput == null)
			mTxtInput = new ControlFactory().createTextField(30);
		
		return(mTxtInput);
	}
	
	protected JLabel getInputLabel()
	{
		if(mLblInput == null)
			mLblInput = new ControlFactory().createLabel("Input:", 'I', getInputField());
		
		return(mLblInput);
	}
	
	protected JButton getLoadFileButton()
	{
		if(mBtnLoadFile == null)
			mBtnLoadFile = new ControlFactory().createButton(new LoadAction(getInputField(), getTypeField(), getImageDataPanel(), getDataTable(), getDataField()));
		
		return(mBtnLoadFile);
	}
	
	protected JTextField getOutputField()
	{
		if(mTxtOutput == null)
			mTxtOutput = new ControlFactory().createTextField(30);
		
		return(mTxtOutput);
	}
	
	protected JLabel getOutputLabel()
	{
		if(mLblOutput == null)
			mLblOutput = new ControlFactory().createLabel("Output:", 'O', getOutputField());
		
		return(mLblOutput);
	}
	
	protected JComboBox<ImageType> getTypeField()
	{
		if(mCboType == null)
			{
			mCboType = new JComboBox<ImageType>(ImageType.values());
			}
		
		return(mCboType);
	}
	
	protected JLabel getTypeLabel()
	{
		if(mLblType == null)
			mLblType = new ControlFactory().createLabel("Type", 'T', getTypeField());
		
		return(mLblType);
	}
	
	protected JButton getWriteFileButton()
	{
		if(mBtnWriteFile == null)
			mBtnWriteFile = new ControlFactory().createButton(new WriteAction());
		
		return(mBtnWriteFile);
	}
	
	
	protected void initControls()
	{
		GridBagConstraints gc = new GridBagConstraints();
		JPanel pnlButtons = new JPanel(new BorderLayout(5, 5)), pnlData = new JPanel(new CardLayout(5, 5));
		
		gc.gridx = gc.gridy = 0;
		gc.gridheight = gc.gridwidth = 1;
		add(getInputLabel(), gc);
		
		gc.gridx++;
		add(getInputField(), gc);
		
		gc.gridx++;
		add(getBrowseInputButton(), gc);
		
		gc.gridy++;
		gc.gridx = 0;
		add(getTypeLabel(), gc);
		
		gc.gridx++;
		add(getTypeField(), gc);
		
		gc.gridy++;
		gc.gridx = 0;
		add(getOutputLabel(), gc);
		
		gc.gridx++;
		add(getOutputField(), gc);
		
		gc.gridx++;
		add(getBrowseOutputButton(), gc);
		
		pnlData.add(getImageDataPanel(), "Image");
		pnlData.add(getDataTable(), "Table");
		pnlData.add(getDataField(), "Text");
		
		gc.gridy++;
		gc.gridx = 0;
		gc.gridwidth = 2;
		add(pnlData, gc);
		
		pnlButtons.add(getLoadFileButton(), BorderLayout.NORTH);
		pnlButtons.add(getWriteFileButton(), BorderLayout.SOUTH);
		
		gc.gridx+=2;
		gc.gridwidth = 1;
		add(pnlButtons, gc);
		
	}
	
	@PostConstruct
	protected void initPanel()
	{
		initControls();
	}
}
