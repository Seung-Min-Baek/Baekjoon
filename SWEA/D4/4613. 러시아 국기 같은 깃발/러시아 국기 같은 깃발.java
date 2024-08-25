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

			char[][] flag = new char[n][m];

			for (int i = 0; i < n; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < m; j++) {
					flag[i][j] = line[j];
				}
			}

			int min = n*m;
			for (int wTob = 1; wTob <= n - 2; wTob++) {
				for (int bTor = wTob + 1; bTor <= n - 1; bTor++) {
					int cnt = 0;

					for (int w = 0; w < wTob; w++) {
						for (int j = 0; j < m; j++) {

							if (flag[w][j] != 'W') {
								cnt++;
							}
						}
					}
					for (int b = wTob; b < bTor; b++) {
						for (int j = 0; j < m; j++) {

							if (flag[b][j] != 'B') {
								cnt++;
							}
						}
					}
					for (int r = bTor; r < n; r++) {
						for (int j = 0; j < m; j++) {

							if (flag[r][j] != 'R') {
								cnt++;
							}
						}
					}
					if (cnt<min) {
						min = cnt;
					}
				}
			}
			System.out.println("#" + test + " " +min);
		}
	}
}
