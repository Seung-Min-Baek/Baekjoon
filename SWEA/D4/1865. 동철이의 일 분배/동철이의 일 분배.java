import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static double result;
	static int[][] persent;
	static int[] work;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			
			persent = new int[n][n];
			visited = new boolean[n];
			result = 0;
			
			for (int i = 0; i < persent.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < persent[i].length; j++) {
					persent[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 100);
			System.out.printf("#%d %.6f\n", t, result);
			
		}
	}

	static void dfs(int depth, double nowP) {
		if(result >= nowP)
			return;
		
		if(depth == n) {
			result = Math.max(result, nowP);
			return;
		}
		
		
		for (int i = 0; i < persent.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(depth+1, nowP*persent[depth][i]*0.01);
				visited[i] = false;
			}
		}
		
	}
}
