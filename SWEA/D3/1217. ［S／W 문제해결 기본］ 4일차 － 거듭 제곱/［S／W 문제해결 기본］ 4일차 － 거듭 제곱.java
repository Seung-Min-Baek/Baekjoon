import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 0; t < 10; t++) {
		int test = sc.nextInt();

			int n = sc.nextInt();
			int m = sc.nextInt();

			System.out.println("#" +test + " " +pow(n, m));
		}
	}

	static int pow(int n, int m) {
		if (m == 1) {
			return n;
		}
		// 짝수이면
		if (m % 2 == 0) {
			return pow(n, m / 2) * pow(n, m / 2);
		}
		// 홀수이면
		else {
			return pow(n, (m - 1) / 2) * pow(n, (m - 1) / 2) * n;
		}
	}
}
