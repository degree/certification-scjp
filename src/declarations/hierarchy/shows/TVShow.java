package declarations.hierarchy.shows;

import declarations.hierarchy.org.NewsAgency;
import declarations.hierarchy.people.Reporter;

/**
 * @author Yauhen Dubrouka
 */
public class TVShow {
	public static void main(String[] args) {
		final NewsAgency agency = new NewsAgency();
		final Reporter reporter = agency.getReporter();
		final String report = reporter.report("hot news");
		System.out.println(report);
	}
}
