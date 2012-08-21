package declarations.constructors;

/**
 * @author Yauhen Dubrouka
 */
@SuppressWarnings("ClassInitializerMayBeStatic")
public class Floating {
	{
		System.out.println("floating 1");
	}

	public Floating() {
		System.out.println("Constructor");
	}

	{
		System.out.println("floating 2");
	}

	public static void main(String[] args) {
		new Floating();
	}
}
