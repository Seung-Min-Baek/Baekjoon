import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] check;
	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		check = new int[100001];
		System.out.println(bfs(n));
	}

	private static int bfs(int n) {
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(n);
		check[n] = 0;

		while (!q.isEmpty()) {
			int x = q.poll();

			if (x == k) {
				return check[x];
			}
			if (x - 1 >= 0 && check[x - 1] == 0) {
				check[x - 1] = check[x] + 1;
				q.add(x - 1);
			}
			if (x + 1 < check.length && check[x + 1] == 0) {
				check[x + 1] = check[x] + 1;
				q.add(x + 1);
			}
			if (x * 2 < check.length && check[x * 2] == 0) {
				check[x * 2] = check[x] + 1;
				q.add(x * 2);
			}
		}
		return 0;
	}
}
