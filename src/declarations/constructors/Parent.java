package declarations.constructors;

/**
 * User: Eugene Dubrovka
 * Date: 12/20/11
 * Time: 12:25 PM
 */
public class Parent
{
	private int x;
	protected int test = 42;

	{
		System.out.println(Parent.class.getName() + " block");
	}

	protected Parent(int _x)
	{
		System.out.println(Parent.class.getName() + " pre " + x);
		this.x = _x;
		System.out.println(Parent.class.getName() + " pre " + x);
		System.out.println(Parent.class.getName() + " test " + test);
//		throw new RuntimeException("Mauh-ha-ha!");
	}

	protected int getX()
	{
		return x;
	}
}
