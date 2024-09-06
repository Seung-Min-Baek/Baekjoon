import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[][] relation;
	static boolean[] visited;
	static int n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test = Integer.parseInt(br.readLine());
		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			relation = new int[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				relation[p1][p2] = relation[p2][p1] = 1;
			}
			int cnt = 0;
			visited = new boolean[n + 1];
			for (int i = 1; i < n + 1; i++) {
				if (!visited[i]) {
					cnt++;
					party(i);
				}
			}
			System.out.println("#" + t + " " +cnt);
		}
	}

	private static void party(int p) {

		visited[p] = true;
		for (int i = 1; i < n + 1; i++) {
			if (relation[p][i] == 1 && !visited[i]) {
				visited[i] = true;
				party(i);
			}
		}
	}

}
