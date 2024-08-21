import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] res_map;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// res_map 그리기
		res_map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[j] = false;
			}
			for (int j = 0; j < n; j++) {
				// 1. 간선 ( 연결된 부분이 1이고, false) dfs 0->1 1이 끝.
				if (map[i][j] == 1 && !visited[j]) {
					dfs(i, j);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res_map[i][j] + " ");
			}
			System.out.println();
		}

	}
		
	static void dfs(int r, int c) {
		// 3. (0,2) 
		// 5. (0,0)
		res_map[r][c] = 1;
		visited[c] = true;
		
		for (int i = 0; i < n; i++) {
			// 2. 1->2 부분, 1이 시작. 연결되었으므로 dfs(0,2)
			// 4. 2->0 부분. 연결되었으므로 dfs(0,0)
			if (map[c][i] == 1 && !visited[i]) {
				dfs(r, i);
			}
		}
	}
}
