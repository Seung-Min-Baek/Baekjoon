import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] connect;
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int com = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		connect = new ArrayList[com+1];
		for (int i = 0; i < com+1; i++) {
			connect[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			connect[p].add(q);
			connect[q].add(p);
		}
		visited = new boolean[com+1];
		System.out.println(dfs(1));
	}
	private static int dfs(int x) {
		visited[x] = true;
		for (int i : connect[x]) {
			if (!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		return cnt;
	}
}
