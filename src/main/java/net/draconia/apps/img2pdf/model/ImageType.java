package net.draconia.apps.img2pdf.model;

public enum ImageType
{
	IMAGE(0, "Image")
,	TABLE(1, "Table")
,	TEXT(2, "Text");

	private int miId;
	private String msDescription;

	private ImageType(final int iId, final String sDescription)
	{
		setId(iId);
		setDescription(sDescription);
	}
	
	public String getDescription()
	{
		return(msDescription);
	}
	
	public int getId()
	{
		return(miId);
	}
	
	private void setDescription(final String sDescription)
	{
		msDescription = sDescription;
	}
	
	private void setId(final int iId)
	{
		miId = iId;
	}
}