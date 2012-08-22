package declarations.hierarchy;

/**
 * @author Yauhen Dubrouka
 */
public class B extends A {
	@Override
	protected int test(Integer a) throws IllegalArgumentException {
		return super.test(a);
	}

	@Override
	public B test(Long a) throws IllegalArgumentException {
		return new B();
	}

	@Override
	public String toString() {
		return "B";
	}
}
