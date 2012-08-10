package exceptions;

import java.io.File;

/**
 * @author Yauhen Dubrouka
 */
public class Handling {
	public static void main(String[] args) {
		try {
			final File file = new File("resources/image.jpg");
			final File[] files = file.listFiles();
		} catch (NullPointerException|SecurityException e) {  // e is implicitly final
			System.out.println("Something's wromg, shut the light... (C) Metallica");
		}
	}
}
