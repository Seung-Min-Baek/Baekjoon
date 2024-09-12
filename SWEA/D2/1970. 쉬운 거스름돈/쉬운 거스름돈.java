import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			int n = Integer.parseInt(br.readLine());

			System.out.println("#" + test);
			for (int i = 0; i < money.length; i++) {
				int p = n/money[i];
				System.out.print(p + " ");
				n = n-p*money[i];
			}
			System.out.println();
		}

	}
}
