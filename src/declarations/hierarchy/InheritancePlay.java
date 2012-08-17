package declarations.hierarchy;

public class InheritancePlay {

	public static class Parent {
		public void doJob(Worker worker) {
			System.out.println("this is " + this.getClass().getName());

			worker.print(this);
		}
	}

	public static class Child extends Parent {
	}

	public static class Worker {
		public void print(Parent parent) {
			System.out.println("Why this method resolution happens?");
		}

		public void print(Child child) {
			System.out.println("This is not called");
		}
	}

	public static void main(String[] args) {
		Child child = new Child();
		Worker worker = new Worker();

		child.doJob(worker);
	}
}