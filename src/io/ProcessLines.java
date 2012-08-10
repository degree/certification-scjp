package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Yauhen Dubrouka
 */
public class ProcessLines {
	public static void main(String[] args) {
		try (
				BufferedReader reader = new BufferedReader(new FileReader("resources/xanadu.txt"));
				PrintWriter writer = new PrintWriter("work/xanadu_processed.txt")
		) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.println(line.toUpperCase());
			}
		} catch (IOException ignored) {
		}
	}
}
