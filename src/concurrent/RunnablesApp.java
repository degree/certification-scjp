package concurrent;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * @author Yauhen Dubrouka
 */
public class RunnablesApp {
	static class Printer implements Runnable {
		final String name;

		Printer(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println(name + ": " + i);
			}
		}
	}

	static class Scheduler implements Runnable {
		private final Collection<Runnable> runnables;

		Scheduler(Collection<Runnable> runnables) {
			this.runnables = runnables;
		}

		@Override
		public void run() {
			for (Runnable runnable : runnables) {
				try {
					System.out.println("Running: " + runnable.toString());
					runnable.run();
				} catch (Exception e) {
					System.out.println("Something wrong happened: " + e.getMessage());
				}
			}
		}
	}

	public static void main(String[] args) {

		Collection<Runnable> runnables = new LinkedHashSet<>();

		for (int i = 0; i < 5; i++) {
			runnables.add(new Printer("printer" + i) {
				@Override
				public String toString() {
					return "Printer: " + name;
				}
			});
		}

		Thread scheduler = new Thread(new Scheduler(runnables));
		scheduler.start();
		try {
			scheduler.join();
		} catch (InterruptedException e) {
			System.out.println("Failed to join: " + e.getMessage());
		}
		System.out.println("Finished");
	}
}
