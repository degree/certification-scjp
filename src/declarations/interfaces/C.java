package declarations.interfaces;

/**
 * User: Eugene Dubrovka
 * Date: 11/29/11
 * Time: 11:32 AM
 */
public abstract class C extends B
{
//	public final static String CONST = "CONST_OVERRIDDEN";

	@Override
	abstract void foo();

	@Override abstract public void baz();
}
