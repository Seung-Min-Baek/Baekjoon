import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int l;
	static int[][] map;
	static boolean[] visited;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());

			map = new int[n][2];
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				// score
				map[i][0] = Integer.parseInt(st.nextToken());
				// cal
				map[i][1] = Integer.parseInt(st.nextToken());
			}
			max = 0;
			dfs(0, 0, 0);
			System.out.println("#" + test + " " +max);

		}
	}

	static void dfs(int idx, int scr, int cal) {

		if (cal > l) {
			return;
		} else {
			max = Math.max(max, scr);
		}
		
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, scr + map[i][0], cal + map[i][1]);
				visited[i] = false;

			}
		}
	}
}
