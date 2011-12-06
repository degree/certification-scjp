package declarations.modifiers;

/**
 * User: Eugene Dubrovka
 * Date: 11/29/11
 * Time: 11:22 AM
 */
public class B extends A
{
	//Override is not allowed here because we override nothing
	private void fooPrivate()
	{

	}

//	@Override void fooDefault()
	@Override protected void fooDefault()
	{
		super.fooDefault();
	}

	// fooProtected() in declarations.modifiers.B cannot override fooProtected() in declarations.modifiers.A; attempting to assign weaker access privileges; was protected
//	@Override void fooProtected()
	@Override public void fooProtected()
	{
		super.fooProtected();
	}

	// only public
	@Override public void fooPublic()
	{
		super.fooPublic();
	}

	public static void myFoo()
	{
		// do nothing
	}
}
