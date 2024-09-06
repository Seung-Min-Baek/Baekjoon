import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 남,북,동,서, 상,하
	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int L, R, C;
	static char[][][] c;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 상범 빌딩의 층 수
			L = Integer.parseInt(st.nextToken());
			// 한 층의 행
			R = Integer.parseInt(st.nextToken());
			// 한 층의 열
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R==0 && C==0) {
				return;
			}
			int si = 0;
			int sj = 0;
			int sk = 0;

			c = new char[L][R][C];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					char[] line = br.readLine().toCharArray();
					for (int k = 0; k < C; k++) {
						c[i][j][k] = line[k];
						if (line[k] == 'S') {
							si = i; // z
							sj = j; // r
							sk = k; // c
							c[si][sj][sk] = '.';
						}
					}
				}
				br.readLine();
			}
			bfs(si, sj, sk); // z r c

		}
	}

	static void bfs(int si, int sj, int sk) {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[L][R][C];

		visited[si][sj][sk] = true;
		q.add(new int[] { si, sj, sk, 0 });

		while (!q.isEmpty()) {
			int[] point = q.poll();
			int z = point[0];
			int x = point[1];
			int y = point[2];
			int move = point[3];
			if (c[z][x][y] == 'E') {
				System.out.println("Escaped in " + move + " minute(s).");
				return;
			}

			for (int i = 0; i < 6; i++) {
				int nz = z + dz[i];
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (R <= nr || nr < 0 || C <= nc || nc < 0 || L <= nz || nz < 0) {
					continue;
				}
				if (visited[nz][nr][nc]) {
					continue;
				}
				if (c[nz][nr][nc] == '.' || c[nz][nr][nc] == 'E') {
					q.add(new int[] { nz, nr, nc, move + 1 });
					visited[nz][nr][nc] = true;
				}
			}
		}
		System.out.println("Trapped!");
	}

}
