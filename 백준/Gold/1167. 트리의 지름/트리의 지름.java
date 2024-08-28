import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int e;
	int value;

	public Node(int e, int value) {
		this.e = e;
		this.value = value;
	}
}

public class Main {
	static int[] dist;
	static ArrayList<Node>[] tree;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 트리의 정점의 개수
		int v = Integer.parseInt(br.readLine());
		tree = new ArrayList[v+1];
		for (int i = 1; i < v + 1; i++) {
			tree[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			while (true) {
				int m = Integer.parseInt(st.nextToken());
				if (m == -1)
					break;
				int V = Integer.parseInt(st.nextToken());
				tree[n].add(new Node(m, V));
			}
		}
		visited = new boolean[v + 1];
		dist = new int[v + 1];
		bfs(1);
		int Max = 1;
		for (int i = 2; i <= v; i++) {
			if (dist[Max] < dist[i])
				Max = i;
		}

		visited = new boolean[v + 1];
		dist = new int[v + 1];
		bfs(Max);
		Arrays.sort(dist);

		System.out.println(dist[v]);
	}

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visited[x] = true;
		while (!q.isEmpty()) {
			int now_node = q.poll();
			for (Node i : tree[now_node]) {
				int e = i.e;
				int v = i.value;
				if (!visited[e]) {
					visited[e] = true;
					q.add(e);
					dist[e] = dist[now_node] + v;
				}
			}
		}

	}
}
