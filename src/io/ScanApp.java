package io;

import java.io.StringReader;
import java.util.Scanner;

/**
 * @author Yauhen Dubrouka
 */
public class ScanApp {
	public static void main(String[] args) {
		String stream = "nothing else matters";
		try (Scanner scanner = new Scanner(new StringReader(stream))) {
			scanner.useDelimiter("t");
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
			}
		}

		System.out.format("%ndefault: %f%nformatted: %1$+020.10f%%%nprevious: %<+5.4f", Math.PI);
	}
}
