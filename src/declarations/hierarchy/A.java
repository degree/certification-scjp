package declarations.hierarchy;

/**
 * @author Yauhen Dubrouka
 */
public class A {
	protected int test(int a) throws IllegalArgumentException {
		return 1;
	}

	protected int test(Integer a) throws IllegalArgumentException {
		return 2;
	}

	protected int test(long a) throws IllegalArgumentException {
		return 3;
	}

	protected int test(Long a) throws IllegalArgumentException {
		return 4;
	}

	public static void main(String[] args) {
		final A a = new A();
		System.out.println(a.test(1));
		System.out.println(a.test(new Integer(1)));
		System.out.println(a.test(1L));
		System.out.println(a.test(new Long(1L)));
	}
}
