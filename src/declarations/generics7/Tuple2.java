package declarations.generics7;

/**
 * @author Yauhen Dubrouka
 */
public class Tuple2<T1, T2> implements AbstractTuple2<T1, T2> {
	private T1 t1;
	private T2 t2;

	public Tuple2(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public T1 getT1() {
		return t1;
	}

	@Override
	public T2 getT2() {
		return t2;
	}

	@Override
	public String toString() {
		return "Tuple2{" + "t1=" + getT1() + ", t2=" + getT2() + '}';
	}

	public static void main(String[] args) {
		final Tuple2<Box<String>, Box<Integer>> container = new Tuple2<>(new Box<>("degree"), new Box<>(123));
		System.out.println(container);
	}
}
