import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int cnt;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

//		인접 노드 간 간선 표현할 배열 1~6 x 1~6
		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			arr[u][v] = arr[v][u] = 1;

		}
		for (int i = 1; i < n+1; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);
	}

	static void dfs(int x) {
//		연결되어있는 간선들 순환이 모두 끝나면 count
		visited[x] = true;

		for (int i = 1; i < arr.length; i++) {
			if (arr[x][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}
