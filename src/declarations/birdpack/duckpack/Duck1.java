package declarations.birdpack.duckpack;

import declarations.birdpack.Bird;

/**
 * @author Yauhen Dubrouka
 */
public class Duck1 extends Bird {

	public void feathers() {
		nFeathers = 10000;
	}

	public static void main(String[] args) {
		final Duck1 duck1 = new Duck1();
		duck1.feathers();
	}
}
