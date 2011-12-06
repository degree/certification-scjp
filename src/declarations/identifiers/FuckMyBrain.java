package declarations.identifiers;

/**
 * User: Eugene Dubrovka
 * Date: 12/6/11
 * Time: 11:09 AM
 */
public class FuckMyBrain
{
	private int \u0420;
	private String можноПисатьПоРусски;

	public int get\u0420()
	{
		return this.\u0420;
	}

	public void set\u0420(int \u0420)
	{
		this.\u0420 = \u0420;
	}

	public String getМожноПисатьПоРусски()
	{
		return можноПисатьПоРусски;
	}

	public void setМожноПисатьПоРусски(String можноПисатьПоРусски)
	{
		this.можноПисатьПоРусски = можноПисатьПоРусски;
	}

	public static void main(String[] args)
	{
		FuckMyBrain fuckMyBrain = new FuckMyBrain();

		fuckMyBrain.set\u0420(42);
		System.out.println(fuckMyBrain.get\u0420());

		fuckMyBrain.setМожноПисатьПоРусски("fourty two");
		System.out.println(fuckMyBrain.getМожноПисатьПоРусски());

	}
}
