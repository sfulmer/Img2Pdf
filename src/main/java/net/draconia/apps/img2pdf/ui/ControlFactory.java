package net.draconia.apps.img2pdf.ui;

import java.awt.Component;
import java.awt.Font;

import java.io.File;
import java.io.Serializable;

import java.util.List;
import java.util.Map;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.filechooser.FileFilter;

public class ControlFactory implements Serializable
{
	private static final long serialVersionUID = 7529931553466061848L;
	
	public JButton createButton(final Action actButton)
	{
		JButton btn = new JButton(actButton);
		
		return(btn);
	}
	
	public JFileChooser getFileChooser(final Map<String, List<String>> mapFilters)
	{
		JFileChooser dlg = new JFileChooser();
		
		for(String sFilterDescription : mapFilters.keySet())
			dlg.addChoosableFileFilter(new FileFilter()
			{
				public String getDescription()
				{
					List<String> lstExts = null;
					String sDescription = sFilterDescription + "(";
					
					lstExts = mapFilters.get(sFilterDescription);
					
					for(int iLength = lstExts.size(), iLoop = 0; iLoop < iLength; iLoop++)
						{
						sDescription += "*." + lstExts.get(iLoop);
						
						if(iLoop < (iLength - 1))
							sDescription += ", ";
						}
					
					sDescription += ")";
					
					return(sDescription);
				}
				
				public boolean accept(final File file)
				{
					List<String> lstExts = mapFilters.get(sFilterDescription);
					
					for(String sExt : lstExts)
						if(file.getAbsolutePath().endsWith(sExt))
							return(true);
					
					return(false);
				}
			});
		
		dlg.setAcceptAllFileFilterUsed(false);
		dlg.setFileSelectionMode(JFileChooser.FILES_ONLY);
		dlg.setMultiSelectionEnabled(false);
		
		return(dlg);
	}
	
	public JLabel createLabel(final String sLabelText, final char cMnemonic, final Component objLabelFor)
	{
		JLabel lbl = new JLabel(sLabelText);
		
		lbl.setDisplayedMnemonic(cMnemonic);
		lbl.setFont(new Font("Arial", Font.BOLD, 10));
		lbl.setLabelFor(objLabelFor);
		lbl.setOpaque(false);
		
		return(lbl);
	}
	
	JTextField createTextField(final int iColumns)
	{
		JTextField txt = new JTextField(iColumns);
		txt.setBorder(BorderFactory.createLoweredBevelBorder());
		txt.setFont(new Font("Arial", Font.PLAIN, 10));
		
		return(txt);
	}
}