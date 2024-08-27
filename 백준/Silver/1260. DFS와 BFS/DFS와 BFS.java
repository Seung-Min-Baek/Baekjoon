import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(v);
	}

	static void dfs(int x) {

		visited[x] = true;
		System.out.print(x + " ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[x][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();

		q.add(x);
		visited[x] = true;
		System.out.print(x + " ");
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < arr.length; i++) {
				if (arr[temp][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}

	}
}
