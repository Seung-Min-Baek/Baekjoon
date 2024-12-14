import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int row, col;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());

		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());

			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			int bug = Integer.parseInt(st.nextToken());

			int bugCount = 0;
			map = new int[row][col];

			for (int i = 0; i < bug; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
			}

			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (map[r][c] == 1) {
						bugCount++;
						dfs(r, c);

					}

				}
			}
			System.out.println(bugCount);

		}
	}

	private static void dfs(int r, int c) {

		map[r][c] = 0;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (0 <= nr && 0 <= nc && nr < row && nc < col && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}
