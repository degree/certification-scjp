package concurrent;

/**
 * @author Yauhen Dubrouka
 */
public class DeadLock {

	static class Friend {
		private final String name;

		public String getName() {
			return name;
		}

		Friend(String name) {
			this.name = name;
		}

		synchronized void bow(Friend friend) {
			System.out.format("%s: %s bowed to me\n", this.name, friend.getName());
			friend.bowBack(this);
		}

		synchronized void bowBack(Friend friend) {
			System.out.format("%s: %s bowed back to me\n", this.name, friend.getName());
		}
	}

	public static void main(String[] args) {
		final Friend foo = new Friend("Foo");
		final Friend bar = new Friend("Bar");

		new Thread(new Runnable() {
			@Override
			public void run() {
				foo.bow(bar);
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				bar.bow(foo);
			}
		}).start();

		// Deadlock
	}
}
