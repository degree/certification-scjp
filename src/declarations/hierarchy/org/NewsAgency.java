package declarations.hierarchy.org;

import declarations.hierarchy.people.Reporter;

/**
 * @author Yauhen Dubrouka
 */
public class NewsAgency {
	public Reporter getReporter() {
		return new ReporterImpl();
	}

	protected class ReporterImpl implements Reporter {
		@Override
		public String report(String topic) {
			return topic + ": important info";
		}
	}
}
