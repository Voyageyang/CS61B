package disc01;

public class Fibonacci02 {
	public static void main(String[] args) {
		System.out.println(fib2(5, 1, 0, 1));
	}

	public static int fib2(int n, int k, int f0, int f1) {
		if(n == k) return f0;
		else return fib2(n, k + 1, f1, f0 + f1);
	}
}