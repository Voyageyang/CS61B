public class HelloNumbers {
	public static void main(String[] args) {
		int x = 0;
		int i = 0;
		while(i < 10) {
			System.out.print(x + " ");
			i++;
			x = x + i;
		}
	}
}
