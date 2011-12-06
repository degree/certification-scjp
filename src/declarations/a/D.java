package declarations.a;

import declarations.b.B;

/**
 * User: Eugene Dubrovka
 * Date: 11/29/11
 * Time: 11:12 AM
 */
public class D extends B
{
	void foo()
	{
		System.out.println(inAProtected);

		// inADefault is not public in declarations.a.A; cannot be accessed from outside package
//		System.out.println(inADefault);

		System.out.println(((A) this).inADefault);

		((A) this).fooDefaultA();
	}
}
