import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int A,B,W;
		
		
		public Edge(int a, int b, int w) {
			super();
			A = a;
			B = b;
			W = w;
		}

		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
		
	}
	
	static int[] p; // 대표자를 저장할 배열
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		p = new int[V+1];
		for (int i = 1; i <=V; i++) {
			p[i] =i;
		}
		
		pq = new PriorityQueue<Edge>();
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(A,B,W));
		}// 입력 끝
		
		int mst = 0;
		int res = 0;
		
		while(mst < V-1) {
			Edge cur = pq.poll();
			if (find(cur.A) != find(cur.B)) {
				union(cur.A,cur.B);
				res = res + cur.W;
				mst++;
			}
		}
		System.out.println(res);
		
	}
	
	// a와 b의 집합을 하나로 통합하는 연산
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a!=b) {
			p[b] =a;
		}
	}
	
	// a가 속한 집합의 대표를 가져오는 연산
	private static int find(int a) {
		if (a!=p[a]) {
			p[a] = find(p[a]);
		}
		return p[a];
	}
}
