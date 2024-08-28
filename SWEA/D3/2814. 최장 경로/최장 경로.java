import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int[][] map;
	static boolean[] visited;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= t; test++) {
			String[] line = br.readLine().split(" ");
			// 정점읜 번호 : 1~n
			int n = Integer.parseInt(line[0]);
			// 간선의 개수 : 1~m
			int m = Integer.parseInt(line[1]);
			
			map = new int[n+1][n+1];
			for (int i = 0; i < m; i++) {
				String[] liner = br.readLine().split(" ");
				int x = Integer.parseInt(liner[0]);
				int y = Integer.parseInt(liner[1]);
				map[x][y] = map[y][x] = 1;
				
				
				
			}
			max = 0;
			for (int i = 1; i < n+1; i++) {
				
			visited = new boolean[n+1];
			dfs(i,0);
			}
			max +=1;
			System.out.println("#" + test + " " + max);
			
		}
		
	}
	
	static void dfs(int x, int cnt) {
		
		max = Math.max(max, cnt);
		
		visited[x] = true;
		
		for (int i = 1; i < map.length; i++) {
			if (map[x][i] == 1 && !visited[i]) {
				visited[i] = true;
				dfs(i,cnt+1);
				visited[i] = false;
			}
		}
	}
}
