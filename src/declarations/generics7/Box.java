package declarations.generics7;

/**
 * @author Yauhen Dubrouka
 */
public class Box<T> {
	private T contents;

	public Box(T contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Box{" + "contents=" + contents + '}';
	}
}
