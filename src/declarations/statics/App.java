package declarations.statics;

import static declarations.statics.StaticClassForMySuperPuperCalculation.*;

/**
 * User: Eugene Dubrovka
 * Date: 12/6/11
 * Time: 12:01 PM
 */
@SuppressWarnings({"AccessStaticViaInstance", "ConstantConditions", "UnusedDeclaration"})
public class App
{
	public static void main(String[] args)
	{
		B b = new B();
		b.foo();

		((A) b).foo();
		((A) null).foo();
		((B) null).foo();

		String aConst = CONST;
		String aConst2 = StaticClassForMySuperPuperCalculation.CONST2;
	}
}
