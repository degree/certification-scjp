package declarations.b;

import declarations.a.A;

/**
 * User: Eugene Dubrovka
 * Date: 11/29/11
 * Time: 11:07 AM
 */
public class B extends A
{
	void foo()
	{
		// inADefault is not public in declarations.a.A; cannot be accessed from outside package
//		System.out.println(this.inADefault);
		System.out.println(this.inAProtected);
	}
}
