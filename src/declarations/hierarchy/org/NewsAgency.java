package declarations.hierarchy.org;

import declarations.hierarchy.people.Reporter;

/**
 * @author Yauhen Dubrouka
 */
public class NewsAgency {
	public Reporter getReporter() {
		return new ReporterImpl();
	}

	public Reporter specialCorrespondent() {
		return new Reporter() {
			@Override
			public String report(String topic) {
				return "breaking news '" + topic + "': info";
			}

			@Override
			public String toString() {
				return "Special correspondent";
			}
		};
	}

	protected class ReporterImpl implements Reporter {
		@Override
		public String report(String topic) {
			return topic + ": important info";
		}
	}
}
