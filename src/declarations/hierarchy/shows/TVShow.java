package declarations.hierarchy.shows;

import declarations.hierarchy.org.NewsAgency;
import declarations.hierarchy.people.Reporter;

/**
 * @author Yauhen Dubrouka
 */
public class TVShow {

	public static final String TOPIC = "hot news";

	public static void main(String[] args) {
		final NewsAgency agency = new NewsAgency();

		final Reporter reporter = agency.getReporter();
		final Reporter specialReporter = agency.specialCorrespondent();
		final Reporter anonymous = agency.anonymous();

		System.out.println(reporter.report(TOPIC));
		System.out.println(specialReporter.toString() + ": " + specialReporter.report(TOPIC));
		System.out.println(anonymous.report(TOPIC));
	}
}
