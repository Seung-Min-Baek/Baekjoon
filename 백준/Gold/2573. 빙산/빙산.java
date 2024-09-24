import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 가로, 세로, 빙산 덩어리 수
	static int n, m, loafNum, meltPeriod = 0;
	static int[][] Antartica, meltAmount;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		// 입력
		init();

		while (true) {
			loafNum = 0;
			visited = new boolean[n][m];

			// 덩어리 개수 구하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (Antartica[i][j] > 0 && !visited[i][j]) {
						loaf(i, j);
						loafNum++;
					}
				}
			}

			// 빙산이 모두 녹은 경우
			if (loafNum == 0) {
				System.out.println(0);
				return;
			}

			// 빙산이 두 덩어리 이상으로 나뉜 경우
			if (loafNum >= 2) {
				System.out.println(meltPeriod);
				return;
			}

			// 녹을 빙산 계산
			meltAmount = new int[n][m];

			// 빙산 녹이기 (녹일 양을 먼저 저장)
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (Antartica[i][j] > 0) {
						meltAmount[i][j] = melt(i, j);
					}
				}
			}

			// 빙산 상태 갱신
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					Antartica[i][j] -= meltAmount[i][j];
					if (Antartica[i][j] < 0) {
						Antartica[i][j] = 0;
					}
				}
			}

			meltPeriod++;
		}
	}

	// 입력 받는 부분
	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Antartica = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				Antartica[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	// 빙산이 녹는 양 계산
	private static int melt(int r, int c) {
		int cnt = 0;

		// 4방향 탐색 (상, 하, 좌, 우)
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (0 <= nr && nr < n && 0 <= nc && nc < m) {
				// 인접한 곳이 0이면 빙산 녹음
				if (Antartica[nr][nc] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	// 빙산 덩어리 탐색 (DFS 사용)
	private static void loaf(int r, int c) {
		visited[r][c] = true;

		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc] && Antartica[nr][nc] > 0) {
				loaf(nr, nc);
			}
		}
	}
}
