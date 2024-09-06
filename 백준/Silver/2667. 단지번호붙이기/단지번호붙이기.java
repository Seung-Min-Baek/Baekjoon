import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] map;
//	static boolean[][] visited;
	static int n;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		int count = 0;
		ArrayList<Integer> cntarr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] ==1) {
					count++;
					cntarr.add(bfs(i, j));
				}
			}
		}
		Collections.sort(cntarr);
		System.out.println(count);
		for (Integer integer : cntarr) {
			System.out.println(integer);
		}
	}

	private static int bfs(int r, int c) {
		Queue<int []> q = new LinkedList<>();
		int cnt = 1;
		
		q.offer(new int[] {r,c});
		map[r][c] = 0;
		
		while(!q.isEmpty()) {
			int[] axis = q.poll();
			int x = axis[0];
			int y = axis[1];
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = x + dr[dir];
				int nc = y + dc[dir];
				
				if (0<=nr && nr<n && 0<=nc && nc<n && map[nr][nc] == 1) {
					cnt++;
					map[nr][nc] =0;
					q.add(new int[] {nr,nc});
				}
			}
		}
		return cnt;
	}
}
