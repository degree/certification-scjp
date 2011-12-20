package declarations.constructors;

/**
 * User: Eugene Dubrovka
 * Date: 12/20/11
 * Time: 12:26 PM
 */
public class ParentImpl extends Parent
{
	private ParentImpl()
	{
		super(42);
	}

	public static void main(String... args)
	{
		System.out.println(new ParentImpl().getX());
	}
}
