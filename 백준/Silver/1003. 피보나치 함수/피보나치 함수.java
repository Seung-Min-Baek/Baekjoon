import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[41][2];
		
		dp[0][0] = dp[1][1] = 1;
		dp[0][1] = dp[1][0] = 0;
		
		for (int j = 2; j < 41; j++) {
			dp[j][0] = dp[j-1][0] + dp[j-2][0];
			dp[j][1] = dp[j-1][1] + dp[j-2][1];
		}
		
		
		for (int i = 1; i <= test; i++) {
			
			int n = Integer.parseInt(br.readLine());
			
			System.out.println(dp[n][0] + " " + dp[n][1]);
		}
		
	}
}
