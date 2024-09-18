import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int[] dc = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static int w, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {

					if (!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}

				}
			}
			System.out.println(cnt);
		}

	}

	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { i, j });
		visited[i][j] = true;

		while (!q.isEmpty()) {
			int[] axis = q.poll();
			int r = axis[0];
			int c = axis[1];

			for (int k = 0; k < dr.length; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];

				if (0 <= nr && nr < h && 0 <= nc && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });

				}
			}
		}
	}

}
