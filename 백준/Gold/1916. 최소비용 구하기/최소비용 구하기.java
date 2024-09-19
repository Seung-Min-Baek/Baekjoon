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
		int y;
		int w;

		public Node(int y, int w) {
			super();
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static int n, m;
	static List<Node>[] map;
	static int[] dist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 도시의 개수
		n = Integer.parseInt(br.readLine());
		// 버스의 개수
		m = Integer.parseInt(br.readLine());

		map = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			map[i] = new ArrayList<Node>();
		}
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int depart = Integer.parseInt(st.nextToken());
			int arrive = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			map[depart].add(new Node(arrive, cost));

		}

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		dijkstra(a);
		System.out.println(dist[b]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		dist[start] = 0;
		q.add(new Node(start, 0));

		while (!q.isEmpty()) {
			Node p = q.poll();

			if (visited[p.y])
				continue;
			visited[p.y] = true;

			for (Node node : map[p.y]) {
				if (!visited[node.y] && dist[node.y] > dist[p.y] + node.w) {
					dist[node.y] = dist[p.y] + node.w;
					q.add(new Node(node.y, dist[node.y]));
				}
			}
		}
	}
}
