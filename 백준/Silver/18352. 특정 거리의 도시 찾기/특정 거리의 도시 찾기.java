
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int q;
		int w;
		
		public Edge(int q, int w) {
			super();
			this.q = q;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int n, m, k, x;
	static ArrayList<Edge>[] road;
	static int[] min_Way;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		road = new ArrayList[n + 1];

		for (int i = 1; i < n+1; i++) {
			road[i] = new ArrayList<>();
		}
		// X에서 출발했을때 최소 길이
		min_Way = new int[n + 1];
		Arrays.fill(min_Way, Integer.MAX_VALUE);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			road[p].add(new Edge(q,1));
		}
		dijkstra(x);
		
		int cnt = 0;
		for (int i = 0; i < n + 1; i++) {
			if (min_Way[i] == k) {
				cnt++;
				System.out.println(i);
			}
		}
		if (cnt == 0) {
			System.out.println(-1);
		}
	}

	private static void dijkstra(int input) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited = new boolean[n + 1];
		
		min_Way[input] = 0;

		pq.add(new Edge(input,0));
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(visited[curr.q]) continue;
			visited[curr.q] = true;

			for (Edge node : road[curr.q]) {
				if (!visited[node.q] && min_Way[node.q] > min_Way[curr.q] + node.w) {
					min_Way[node.q] = min_Way[curr.q] + node.w;
					pq.add(new Edge(node.q, min_Way[node.q]));
				}
			}
		}
//	private static void dijkstra(int input) {
//		visited = new boolean[n + 1];
//		min_Way[input] = 0;
//
//		for (int i = 0; i < min_Way.length; i++) {
//			int min = Integer.MAX_VALUE;
//			int idx = -1;
//
//			for (int j = 0; j < n; j++) {
//				if (!visited[j] && min_Way[j] < min) {
//					min = min_Way[j];
//					idx = j;
//				}
//			}
//			if (idx == -1)
//				break;
//
//			visited[idx] = true;
//			for (int node : road[idx]) {
//				if (!visited[node] && min_Way[node] > min_Way[idx] + 1) {
//					min_Way[node] = min_Way[idx] + 1;
//				}
//			}
//		}

	}
}
