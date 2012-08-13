package io.conn;

/**
 * @author Yauhen Dubrouka
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLConnectionReader {
	public static void main(String[] args) {
		try (
				final InputStreamReader inputStreamReader = new InputStreamReader(new URL("http://degree.by/").openConnection().getInputStream());
				final BufferedReader in = new BufferedReader(inputStreamReader)
		) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
		} catch (IOException ignored) {
		}
	}
}