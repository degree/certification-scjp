package concurrent.executors;

import java.util.concurrent.*;

/**
 * @author Yauhen Dubrouka
 */
public class ExecutorApplication {
	public static void main(String[] args) {
		final ExecutorService executorService = Executors.newFixedThreadPool(2);

		System.out.println("submitting a task");

		final Future<Long> longFuture = executorService.submit(new Callable<Long>() {
			@Override
			public Long call() throws Exception {
				Thread.sleep(5000);
				return 1l;
			}
		});

		System.out.println("submitted a task");

		try {
			System.out.println(longFuture.get());
		} catch (InterruptedException e) {
			System.out.println("interrupted");
		} catch (ExecutionException e) {
			System.out.println("execution problems");
		}

		System.out.println("shutting down");

		executorService.shutdown();
	}
}
