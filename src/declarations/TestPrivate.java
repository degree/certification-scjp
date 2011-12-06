package declarations;

/**
 * User: Eugene Dubrovka
 * Date: 11/29/11
 * Time: 11:03 AM
 */
public class TestPrivate
{
	private int x;

	@Override
	public boolean equals(Object that)
	{
		if (this == that) return true;
		if (!(that instanceof TestPrivate)) return false;
		return this.x == ((TestPrivate) that).x;
	}
}
