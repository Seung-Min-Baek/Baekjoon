import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Kak {
		int b;
		int p;
		int q;

		public Kak(int b, int p, int q) {
			this.b = b;
			this.p = p;
			this.q = q;
		}

		public int getB() {
			return b;
		}

		public int getP() {
			return p;
		}

		public int getQ() {
			return q;
		}
	}

	static ArrayList<Kak>[] A;
	static boolean[] visited;
	static long[] D;
	static long ratio;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());

		A = new ArrayList[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			A[i] = new ArrayList<Kak>();
		}
		D = new long[n];
		ratio = 1;

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			A[a].add(new Kak(b, p, q));
			A[b].add(new Kak(a, q, p));
			ratio *= (p * q / gcd(p, q));
		}

		D[0] = ratio;
		dfs(0);
		long mgcd = D[0];
		for (int i = 1; i < n; i++) {
			mgcd = gcd(mgcd,D[i]);
		}
		for (int i = 0; i < n; i++) {
			System.out.print(D[i]/mgcd + " ");
		}
	}

	private static void dfs(int i) {
		visited[i] = true;
		for (Kak j  : A[i]) {
			int next = j.getB();
			if (!visited[next]) {
				D[next] = D[i] * j.getQ() / j.getP();
				dfs(next);
			}
		}
	}

	private static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		} else
			return gcd(b, a % b);
	}
}
