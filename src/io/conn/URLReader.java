package io.conn;

/**
 * @author Yauhen Dubrouka
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
	public static void main(String[] args) {
		try (
				final InputStreamReader insReader = new InputStreamReader(new URL("http://degree.by/").openStream());
				final BufferedReader in = new BufferedReader(insReader)
		) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
		} catch (IOException ignore) { // MalformedURLException is suppressed
		}
	}
}