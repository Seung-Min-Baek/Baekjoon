import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Mst_Node implements Comparable<Mst_Node> {

		int n1, n2, length;

		public Mst_Node(int n1, int n2, int length) {
			this.n1 = n1;
			this.n2 = n2;
			this.length = length;
		}

		@Override
		public int compareTo(Mst_Node o) {
			return this.length - o.length;
		}

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] parent;
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	static ArrayList<Node>[] list; // 모든 섬의 좌표 저장
	static PriorityQueue<Mst_Node> pq; // 섬들간의 간선 정보 저장 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		} // 입력 끝

		// 섬마다 고유 숫자 부여
		list = new ArrayList[7]; // 섬의 최대 개수 7개
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					list[num] = new ArrayList<>();
					bfs(i, j, num);
					num++;
				}
			}
		}
		// 섬을 연결 할 수 있는 방법을 모두 구한다.
		pq = new PriorityQueue<>();
		for (int i = 1; i < num; i++) {
			for (int j = 0; j < list[i].size(); j++) {
				Node island = list[i].get(j);
				for (int k = 0; k < 4; k++) { // 한방향을 가기 위해 방향정보를 넣어줌.
					find_bridge(island.x, island.y, i, k, -1);
				}
			}
		}
		
		/* pq에 들어있는 간선들
		  	2 4 2
			4 2 2
			4 2 2
			2 4 2
			2 3 3
			3 2 3
			1 2 4
			4 1 4
			2 1 4
			1 4 4
		 */
		System.out.println(kruskal(num));
		
	}

	private static int kruskal(int num) {
		// 자기 자신 생성
		parent = new int[num];
		for (int i = 1; i < num; i++) {
			parent[i] = i;
		}
		
		int result = 0; // 최소 길이 저장
		int bridge = 0; // 다리의 개수 저장
		
		while(!pq.isEmpty()) {
			Mst_Node curr = pq.poll();
			
			int p1 = find(curr.n1);
			int p2 = find(curr.n2);
			
			if (p1 != p2) {
				union(p1,p2);
				result += curr.length;
				bridge++;
			}
		}
		
		if (result == 0) { // 다리의 길이의 합이 0이면 불가능
			return -1;
		}
		if (bridge != num-2) { // 다리의 개수가 섬의 개수-1와 같지 않으면 모든 섬 연결 불가능
			return -1;
		}
		return result;
	}

	private static void union(int a, int b) {
		parent[b] = a;
	}

	private static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	// 섬들에 숫자 부여
	private static void bfs(int i, int j, int num) {
		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(i, j));
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();
			int r = curr.x;
			int c = curr.y;

			map[r][c] = num;
			list[num].add(new Node(r, c)); // 섬의 모든 좌표 저장

			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;
				if (visited[nr][nc] || map[nr][nc] != 1)
					continue;
				visited[nr][nc] = true;
				q.offer(new Node(nr, nc));
			}
		}
		
	}

	private static void find_bridge(int x, int y, int num, int dir, int len) {
		if (map[x][y] != 0 && map[x][y] != num) { // 다른 섬을 만남
			if (len >= 2) {
				pq.offer(new Mst_Node(num, map[x][y], len));
			}
			return;
		}
		int nx = x + dr[dir];
		int ny = y + dc[dir];
		if (nx<0 || ny<0 || nx>=n || ny>=m) return;
		if(map[nx][ny] == num) return;
		find_bridge(nx, ny, num, dir, len+1);
	}
	
	

}
