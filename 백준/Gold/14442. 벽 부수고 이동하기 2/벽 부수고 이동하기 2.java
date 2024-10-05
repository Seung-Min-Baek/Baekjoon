import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int x, y, chance, move;

		public Info(int x, int y, int chance, int move) {
			super();
			this.x = x; // x좌표
			this.y = y; // y좌표
			this.chance = chance; // 별 부술수 있는 기회
			this.move = move; // 이동횟수
		}
	}

	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n,m,k, cnt;

	public static void main(String[] args) throws IOException {
		init();
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<Info> q = new LinkedList<>();
		visited = new boolean[n][m][k+1];
		q.add(new Info(0,0,0,1));
		
		cnt = -1;
		
		while(!q.isEmpty()) {
			Info info = q.poll();
			int r = info.x;
			int c = info.y;
			int chance = info.chance;
			int move = info.move;
			
			if (r ==n-1 && c == m-1) {
				return cnt = move;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if (nr<0 || nc<0 || nr>n-1 || nc>m-1) {
					continue;
				}
				if (map[nr][nc] == 0 && !visited[nr][nc][chance]) {
					visited[nr][nc][chance] = true;
					q.add(new Info(nr,nc,chance,move+1));
				}else if(map[nr][nc] == 1 && chance<k && !visited[nr][nc][chance+1]) {
					visited[nr][nc][chance+1] = true;
					q.add(new Info(nr,nc,chance+1,move+1));
				}
			}
		}
		return cnt;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(st.nextToken());

		
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
	}
}
