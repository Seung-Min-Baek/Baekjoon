import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static boolean[] visited;
	static ArrayList<Integer>[] arr;
	static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		for (int i = 1; i < n+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		answer = new int[n+1];
		dfs(1);
		for (int i = 2; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	private static void dfs(int i) {
		visited[i] = true;
		for (Integer j : arr[i]) {
			if (!visited[j]) {
				answer[j] = i;
				dfs(j);
			}
		}
	}
}
