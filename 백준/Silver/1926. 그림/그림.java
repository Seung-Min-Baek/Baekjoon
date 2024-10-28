import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,m,area, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		// 세로 크기
		n = Integer.parseInt(st.nextToken());
		// 가로 크기
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[n][m];
		
		cnt = 0;
		int max_area = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					area = 0;
					cnt +=1;
					bfs(i,j);
					max_area = Math.max(max_area, area);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max_area);
		
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {x,y});
		visited[x][y] = true;
		area +=1;
		
		while(!q.isEmpty()) {
			int[] node = q.poll();
			int r = node[0];
			int c = node[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (0<=nr && 0<=nc && nr<n && nc<m && map[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] =true;
					q.add(new int[] {nr,nc});
					area += 1;
				}
			}
		}
	}
}
