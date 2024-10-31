import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(br.readLine());

		for (int i = 0; i < test; i++) {
			int n = Integer.parseInt(br.readLine());

			int[] dp = new int[n + 1];
			if (n>=1) dp[1] = 1;
			if (n>=2) dp[2] = 2;
			if (n>=3) dp[3] = 4;
			if (n>=4) dp[4] = 7;
			if (n>=5) dp[5] = 13;
			if (n > 5) {
				for (int j = 6; j < n + 1; j++) {
					dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
				}
			}
			
			System.out.println(dp[n]);
		}
	}
}
