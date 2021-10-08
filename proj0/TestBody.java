public class TestBody {
	public static void main(String[] args) {
		TestBody();
	}

	public static void TestBody() {
		System.out.println("Checking Body...");

		Body a = new Body(1, 2, 3, 4, 5, "a.gif");
		Body b = new Body(1, 3, 3, 4, 5, "b.gif");

		System.out.println("The pairwise force between a and b is " + a.calcForceExertedBy(b));
	}
}