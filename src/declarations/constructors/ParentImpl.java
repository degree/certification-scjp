package declarations.constructors;

/**
 * User: Eugene Dubrovka
 * Date: 12/20/11
 * Time: 12:26 PM
 */
public class ParentImpl extends Parent
{
	private int y = 1;

	{
		System.out.println(ParentImpl.class.getName() + " block " + y);
	}

	private ParentImpl()
	{
		// 'this' is not available
		super(42);
		// 'this' is already available
		System.out.println(ParentImpl.class.getName() + " " + y);
		y = 2;
	}


	public int getY()
	{
		return y;
	}

	public static void main(String... args)
	{
		ParentImpl parent = new ParentImpl();
		System.out.println("main: " + parent.getX());
		System.out.println("main: " + parent.getY());
	}
}
