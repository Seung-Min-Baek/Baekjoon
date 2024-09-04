import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Edge {
		int union, a, b;

		public Edge(int union, int a, int b) {
			super();
			this.union = union;
			this.a = a;
			this.b = b;
		}
	}

	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {

			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			Edge[] edges = new Edge[m];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}

			p = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				p[i] = i;
			}

			System.out.print("#" + test + " ");
			for (int i = 0; i < edges.length; i++) {
				int x = edges[i].a;
				int y = edges[i].b;

				// 0이면 집합 합친다.
				if (edges[i].union == 0) {
					union(x, y);

					// 1이면 확인
				} else {
					if (findSet(x) != findSet(y)) {
						System.out.print(0);
					}else {
						System.out.print(1);
					}
				}
			}
			System.out.println();

		}
	}

	static int findSet(int x) {

		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];

	}

	static void union(int x, int y) {
		// x와 y가 대표자 여야만 한다.
		p[findSet(y)] = findSet(x); //
	}
}
