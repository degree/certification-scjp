package concurrent;

/**
 * @author Yauhen Dubrouka
 */
public class SleepMessages {
	public static void main(String[] args) throws InterruptedException {
		String[] infos = {
				"info1",
				"info2",
				"info3",
				"info4"
		};

		for (String info : infos) {
			Thread.sleep(2000);
			System.out.println(info);
		}
	}
}
