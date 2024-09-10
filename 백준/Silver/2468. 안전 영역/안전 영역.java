import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] area;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		area = new int[n][n];

		int max = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, area[i][j]);
			}
		}
		int res = 0;
		for (int day = 0; day < max; day++) {
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (day != 0)
						area[i][j] -= 1;
				}
			}
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && area[i][j] > 0) {
						cnt++;
						bfs(i, j);
					}

				}
			}
			res = Math.max(res, cnt);
		}
		System.out.println(res);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();

		visited[x][y] = true;
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] set = q.poll();
			int r = set[0];
			int c = set[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (0 <= nr && nr < n && 0 <= nc && nc < n && !visited[nr][nc] && area[nr][nc] > 0) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}

			}
		}
	}
}
