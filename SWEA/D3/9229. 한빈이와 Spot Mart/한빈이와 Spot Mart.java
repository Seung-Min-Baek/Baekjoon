import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[] bong = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				bong[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					if (bong[i] + bong[j] <=m) {
						max = Math.max(max, bong[i] + bong[j]);
					}
				}

			}
			if (max == 0) {
				max = -1;
			}
			System.out.println("#" + test + " " + max);

		}
	}

}
