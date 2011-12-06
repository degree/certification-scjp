package declarations.identifiers;

/**
 * User: Eugene Dubrovka
 * Date: 12/6/11
 * Time: 11:09 AM
 */
public class LegalClass
{
	private boolean visible;

	// contentWidth
	public int getContentWidth()
	{
		return 42;
	}

	public void setContentWidth(int contentWidth)
	{
//		this.contentWidth = contentWidth;
	}


	public boolean isVisible()
	{
		return visible;
	}

	public boolean getVisible()
	{
		return visible;
	}

	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}

	public void addMySuperEventListener(MySuperEvent event)
	{

	}

	public void removeMySuperEventListener(MySuperEvent event)
	{

	}

	private class MySuperEvent
	{}
}
