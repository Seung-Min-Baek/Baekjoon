import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		int[][] pyramid = new int[n + 1][n + 1];
		int[][] new_pyramid = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= i; j++) {
				pyramid[i][j] = Integer.parseInt(st.nextToken());
//				System.out.println(pyramid[i][j]);
			}
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j <= i; j++) {

				if (i == 1) {
					new_pyramid[i][j] = pyramid[i][j];
				} else {
					new_pyramid[i][j] = Math.max(new_pyramid[i - 1][j - 1] + pyramid[i][j],
							new_pyramid[i - 1][j] + pyramid[i][j]);
				}
			}
		}
		
		int max_res = 0;
		for (int i = 1; i < n+1; i++) {
			max_res = Math.max(max_res, new_pyramid[n][i]);
		}
		System.out.println(max_res);
	}
}
