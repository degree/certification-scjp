package declarations.constructors;

/**
 * @author Yauhen Dubrouka
 */
@SuppressWarnings("ClassInitializerMayBeStatic")
public class FloatingChild extends Floating {

	{
		System.out.println("Child floating 1");
	}
	public FloatingChild() {
		System.out.println("Child constructor");
	}

	{
		System.out.println("Child floating 2");
	}

	public static void main(String[] args) {
		new FloatingChild();
	}
}
