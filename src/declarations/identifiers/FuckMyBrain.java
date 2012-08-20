package declarations.identifiers;

/**
 * User: Eugene Dubrovka
 * Date: 12/6/11
 * Time: 11:09 AM
 */
@SuppressWarnings("ConstantConditions")
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

		// conditional operator
		boolean a, b, c, d, e, f, g, h, i, j, k, l;
		a = true;
		b = true;
		c = true;
		d = true;
		e = true;
		f = true;
		g = true;
		h = true;
		i = true;
		j = true;
		k = true;
		l = true;
		a = b ? c ? d : e ? f : g : h ? i : j ? k : l;
		a = (/*1>*/b ? (/*2>*/c ? d : (/*3>*/e ? f : g/*<3*/)/*<2*/) : (/*4>*/h ? i : (/*5>*/j ? k : l/*<5*/)/*<4*/)/*<1*/);

	}
}
