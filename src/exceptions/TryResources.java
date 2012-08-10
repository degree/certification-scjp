package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Yauhen Dubrouka
 */
public class TryResources {
	public static void main(String[] args) {
		// BufferedReader is java.lang.AutoCloseable
		try(BufferedReader br = new BufferedReader(new FileReader("resources/xanadu.txt"))) {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
