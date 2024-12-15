import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int m, n, k;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = { 0,0,-1,1};
	static PriorityQueue<Integer> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken()); // 전체 직사각형 높이
		n = Integer.parseInt(st.nextToken()); // 길이
		k = Integer.parseInt(st.nextToken()); // 내부 직사각형 개수

		map = new int[m][n]; // 직사각형 만들기

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int x_left = Integer.parseInt(st.nextToken());
			int y_left = Integer.parseInt(st.nextToken());
			int x_right = Integer.parseInt(st.nextToken());
			int y_right = Integer.parseInt(st.nextToken());

			for (int y = m - y_right; y < m - y_left; y++) {
				for (int x = x_left; x < x_right; x++) {
					map[y][x] = 1;
				}
			}

		}
		
		int area = 0;
		pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0) {
					area++;
					bfs(i,j);
				}
				
			}
		}
		
		System.out.println(area);
		while(!pq.isEmpty()) {
			int count = pq.poll();
			System.out.print(count + " ");
		}

	}

	private static void bfs(int x, int y) {
		
		int cnt = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {x,y});
		map[x][y] = 1;
		while(!q.isEmpty()) {
			int[] ax = q.poll();
			int r = ax[0];
			int c = ax[1];
			cnt++;
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if (0<=nr && 0<=nc && nr<m && nc<n && map[nr][nc] ==0) {
					q.add(new int[] {nr,nc});
					map[nr][nc] = 1;
					
				}
			}
		}
		pq.add(cnt);
		
	}
}
