import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] map, result;
	static boolean[] visited;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n+1][n+1];
		result = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			for (int j = 1; j <= n; j++) {
				if(map[i][j] == 1 && !visited[j])
					dfs(i, j);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	static void dfs(int r, int c) {		
		visited[c] = true;
		result[r][c] = 1;
		
		for (int i = 1; i <= n; i++) {
			if(!visited[i] && map[c][i] == 1) {
				dfs(r, i);
			}
		}

	}

}
