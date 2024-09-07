import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<Integer>[] drdc;
	// 상, 우, 하, 좌 ( 시계방향)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m, r, c, l;

	static int[][] terminal;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			// 지도 세로 크기
			n = Integer.parseInt(st.nextToken());
			// 지도 가로 크기
			m = Integer.parseInt(st.nextToken());
			// 맨홀뚜껑 위치
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			// 탈출 후 소요된시간
			l = Integer.parseInt(st.nextToken());

			terminal = new int[n][m];
			visited = new boolean[n][m];
			drdc = new ArrayList[8];
			for (int i = 0; i < 8; i++) {
				drdc[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < drdc.length; i++) {
				if (i == 0) {
					drdc[i].add(-1);
				}
				else if (i == 1) {
					drdc[i].add(0);
					drdc[i].add(1);
					drdc[i].add(2);
					drdc[i].add(3);
				} else if (i == 2) {
					drdc[i].add(0);
					drdc[i].add(2);
				} else if (i == 3) {
					drdc[i].add(1);
					drdc[i].add(3);
				} else if (i == 4) {
					drdc[i].add(0);
					drdc[i].add(1);
				} else if (i == 5) {
					drdc[i].add(1);
					drdc[i].add(2);
				} else if (i == 6) {
					drdc[i].add(2);
					drdc[i].add(3);
				} else if (i == 7) {
					drdc[i].add(3);
					drdc[i].add(0);
				}
			}

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					terminal[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			// 맨홀 위치부터 시작
			bfs(r, c);
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
//					System.out.print(visited[i][j] + " ");
					if (visited[i][j]) {
						cnt++;
					}
				}
//				System.out.println();
			}
			System.out.println("#" + test + " " +cnt);
		} // testcase
	}// main

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { x, y });
		visited[x][y] = true;

		int dist = 1;
		if (l ==1) return;
		while (!q.isEmpty()) {
			// 너비 우선 탐색이므로 너비를 way로 하여, way가 l과 같으면 break;
			int size = q.size();
			for (int i = 0; i < size; i++) {

				int[] curr = q.poll();
				int curr_x = curr[0];
				int curr_y = curr[1];
				
//				System.out.println("curr_x : " + curr_x + " curr_y : " + curr_y);
				for (int dir : drdc[terminal[curr_x][curr_y]]) {
					int nr = curr_x + dr[dir];
					int nc = curr_y + dc[dir];
					
//					System.out.println("nr : " + nr + " nc : " + nc + " dir : " + dir);
					int stick = (dir + 2) % 4;
//					System.out.println("stick : " + stick);
					// 맵 범위를 넘지 않거나, 아직 방문 안했거나, 0보다 큰 곳
					// 사실 터널 구조물 신경 안써도 됨
					if (0 <= nr && nr < n && 0 <= nc && nc < m && !visited[nr][nc]) {
//						System.out.println(drdc[terminal[nr][nc]].contains(stick));
						if (drdc[terminal[nr][nc]].contains(stick)) {
							// System.out.println(Arrays.deepToString(visited));
							// true로 만들어주고, 나중에 true 개수 셀거임.
							visited[nr][nc] = true;

							q.add(new int[] { nr, nc });
						}
					}
				}
			}
			dist++;
//			System.out.println("dist : " + dist);
			if (dist == l)
				break;
		}
	}
}
