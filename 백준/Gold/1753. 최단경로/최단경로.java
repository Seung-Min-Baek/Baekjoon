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
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static final int INF = 987654321;
	static int V, E;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		adjList = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new int[V + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Node(v, w));
		}

		dijkstra(k);

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == 987654321) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];

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
	}
}
