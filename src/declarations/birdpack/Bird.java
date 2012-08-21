package declarations.birdpack;

/**
 * @author Yauhen Dubrouka
 */
public class Bird {
	protected int nFeathers;

	public static void main(String[] args) {
		new Bird() {
			{
				System.out.println("Bird init");
			}

			public void fly() {
				System.out.println("flying");
			}
		}.fly();
	}
}
