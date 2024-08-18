import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {

			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);

			int[][] balloon = new int[n][m];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					balloon[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					int sum = 0;
					int flower = balloon[r][c];
					sum += flower;
					for (int f = 1; f <= flower; f++) {
						
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d]*f;
							int nc = c + dc[d]*f;
							if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
								sum += balloon[nr][nc];
							}
						}
					}
					if (max<sum) {
						max = sum;
					}

				}
			}
			
			System.out.println("#" + test + " " + max);

		}
	}
}
