package declarations.enumerations;

/**
 * User: Eugene Dubrovka
 * Date: 1/24/12
 * Time: 11:45 AM
 */
public enum TestEnum
{
	ONE("one"), TWO(2, "two"), THREE;
	
	static int x = 0;
	static {
		x = 42;
		System.out.println("static block");
	}

	{ System.out.println("block " + name()); }

	private int id;
	private String name;

	private TestEnum(int id, String name)
	{
		this.id = id;
		this.name = name;
//		System.out.println(TestEnum.x);
	}

	TestEnum(String name)
	{
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	private TestEnum()
	{
	}

	static int getStatic()
	{
		return 42;
	}

	public static void main(String[] args)
	{
		System.out.println("main");
	}
}
