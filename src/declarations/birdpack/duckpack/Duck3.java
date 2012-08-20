package declarations.birdpack.duckpack;

import declarations.birdpack.Bird;

/**
 * @author Yauhen Dubrouka
 */
public class Duck3 extends Bird {
	public void bird() {
		final Bird bird = new Bird();
//		bird.nFeathers = 10000; // won't compile
	}
}
