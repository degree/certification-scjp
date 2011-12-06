package declarations.b;

/**
 * User: Eugene Dubrovka
 * Date: 11/29/11
 * Time: 11:11 AM
 */
public class C
{
	void foo(B b)
	{
		// inADefault is not public in declarations.a.A; cannot be accessed from outside package
//		System.out.println(b.inADefault);

		// inAProtected has protected access in declarations.a.A
//		System.out.println(b.inAProtected);
	}
}
