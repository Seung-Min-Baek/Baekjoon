import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static final int INF = 987654321;
	static int V, E, v1, v2;
	static List<Node>[] adjList; // 인접리스트
	static int[] dist;

	public static void main(String[] args) throws IOException {
		init();

		int res1 = 0;
		res1 += dijkstra(1, v1);
		if (res1 >= INF) {  // 경로가 없는 경우 처리
			System.out.println(-1);
			return;
		}
		res1 += dijkstra(v1, v2);
		if (res1 >= INF) {  // 경로가 없는 경우 처리
			System.out.println(-1);
			return;
		}
		res1 += dijkstra(v2, V);
		if (res1 >= INF) {  // 경로가 없는 경우 처리
			System.out.println(-1);
			return;
		}

		int res2 = 0;
		res2 += dijkstra(1, v2);
		if (res2 >= INF) {  // 경로가 없는 경우 처리
			System.out.println(-1);
			return;
		}
		res2 += dijkstra(v2, v1);
		if (res2 >= INF) {  // 경로가 없는 경우 처리
			System.out.println(-1);
			return;
		}
		res2 += dijkstra(v1, V);
		if (res2 >= INF) {  // 경로가 없는 경우 처리
			System.out.println(-1);
			return;
		}

		int ans = (res1 >= INF && res2 >= INF ? -1 : Math.min(res1, res2));

		System.out.println(ans);
	}

	private static int dijkstra(int start, int end) {
//		if (start == end) return 0; // 출발점과 도착점이 동일한 경우 바로 0 반환
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[V+1];

		dist[start] = 0;

		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visited[curr.v])
				continue;
			visited[curr.v] = true;

			for (Node node : adjList[curr.v]) {
				if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.w) {
					dist[node.v] = dist[curr.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));

				}
			}
		}

		return dist[end];

	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		} // 초기화 완료

		dist = new int[V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			adjList[a].add(new Node(b, p));
			adjList[b].add(new Node(a, p));
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

	}
}