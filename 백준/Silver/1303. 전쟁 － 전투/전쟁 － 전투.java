import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] war;
	static int n, m;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		war = new char[n][m];

		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				war[i][j] = line[j].charAt(0);
			}
		}

		int w_sum = 0;
		int b_sum = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {

				if (war[r][c] == 'W') {
					int cnt = dfs(r, c, 'W');
					w_sum += Math.pow(cnt, 2);
				} else if (war[r][c] == 'B') {
					int cnt = dfs(r, c, 'B');
					b_sum += Math.pow(cnt, 2);
				}

			}
		}
		System.out.print(w_sum + " ");
		System.out.println(b_sum);
	}

	private static int dfs(int r, int c, char d) {
		int cnt = 1;
		war[r][c] = 'S';

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (0 <= nr && 0 <= nc && nr < n && nc < m && war[nr][nc] == d) {
				cnt += dfs(nr, nc, d);
			}
		}
		return cnt;
	}
}
