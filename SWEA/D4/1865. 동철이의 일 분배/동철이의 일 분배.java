import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static double[][] arr;
	static boolean[] visited;
	static double maxp;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			n = Integer.parseInt(br.readLine());

			arr = new double[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()) * 0.01;
				}
			}
			maxp = 0;
			visited = new boolean[n];

			dfs(0, 1);

			System.out.printf("#%d %.6f\n", test, maxp * 100);
		}
	}

	static void dfs(int x, double p) {
		if(p<=maxp) {
			return;
		}
		
		if (x == n) {
			maxp = Math.max(p, maxp);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(x + 1, p * arr[x][i]);
				visited[i] =false;
			}
		}
	}
}