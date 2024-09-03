import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map_copy;
	static boolean[][] visited;
	static int n;
	static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {
			n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			map_copy = new int[n][n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			int maxres = 0;
			// 날이 갈 수록 먹은 치즈 뺴주기
			for (int day = 0; day <= max; day++) {
				visited = new boolean[n][n];
				int cnt = 0;
				
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						map_copy[r][c] = map[r][c]- day;
					}
				}
				
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (map_copy[r][c]>0 && !visited[r][c]) {
							cnt++;
							bfs(r,c);
						}
					}
				}
				maxres = Math.max(maxres, cnt);	
			}
			System.out.println("#" + test + " " +maxres);
		}
	}
	static void bfs(int x, int y) {
		Queue<int []> q = new LinkedList<int[]>();
		
		if (visited[x][y]) {
			return;
		}
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] array = q.poll();
			int r = array[0];
			int c = array[1];
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (0<=nr && 0<= nc && nr<n && nc<n && map_copy[nr][nc]>0 && !visited[nr][nc]) {
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
			
		}
	}
	
}
