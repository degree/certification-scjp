package declarations.modifiers.finals;

/**
 * User: Eugene Dubrovka
 * Date: 1/24/12
 * Time: 11:33 AM
 */
public class FinalClass
{
	final int x;

	{
		x = 42;
	}

	public FinalClass(int x)
	{
//		this.x = x;
		final int y;
//		foo();
	}
	
	private void foo()
	{
//		this.x = 42;
	}
}
