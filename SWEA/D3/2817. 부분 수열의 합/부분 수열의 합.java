import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static boolean[] visited;
	static int n;
	static int m;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= t; test++) {
			st= new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			dfs(0,0);
			System.out.println("#" + test + " " + cnt);
		}
	}
	
	static void dfs(int idx, int sum) {
		if (sum >= m) {
			if (sum == m) {
				cnt++;
				return;
			}
			return;
		}
		
		for (int i = idx; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i+1,sum+arr[i]);
				visited[i] = false;
			}
		}
		
	}
	
}
