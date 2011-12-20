package declarations.constructors;

/**
 * User: Eugene Dubrovka
 * Date: 12/20/11
 * Time: 12:25 PM
 */
public class Parent
{
	private int x;

	protected Parent(int x)
	{
		this.x = x;
	}

	protected int getX()
	{
		return x;
	}
}
