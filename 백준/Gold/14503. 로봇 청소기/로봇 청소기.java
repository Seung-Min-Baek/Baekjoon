import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] room;
	static int cnt = 1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		room = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		robotClean(r, c, d);
		System.out.println(cnt);
	}

	static void robotClean(int r, int c, int dir) {

		// 청소~
		room[r][c] = -1;

		for (int i = 0; i < 4; i++) {
			// 반시계방향으로 회전
			dir = (dir + 3) % 4;

			int nr = r + dr[dir];
			int nc = c + dc[dir];
			// 범위 안에 들고, 0이면 재귀
			if (0 <= nr && nr < n && 0 <= nc && nc < m && room[nr][nc] == 0) {
				cnt++;
				robotClean(nr, nc, dir);
				return;
			}
		}
		// 후진
		int d = (dir + 2) % 4;
		int br = r + dr[d];
		int bc = c + dc[d];
		// 범위 안에 들고 1이 아니면 재귀 , 1이면 끝.
		if (0 <= br && br < n && 0 <= bc && bc < m && room[br][bc] != 1) {
			robotClean(br, bc, dir); // 후진이니까 바라보는 방향은 유지된다.
		}
	}
}
