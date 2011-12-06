package declarations.statics;

/**
 * User: Eugene Dubrovka
 * Date: 12/6/11
 * Time: 12:01 PM
 */
public class App
{
	public static void main(String[] args)
	{
		B b = new B();
		b.foo();

		((A) b).foo();
		((A) null).foo();
		((B) null).foo();
	}
}
