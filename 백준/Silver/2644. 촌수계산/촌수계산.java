import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] parent; 
	static boolean[] visited;
	static int n,p,q;
	static int res;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 전체 사람의 수
		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		
		// 부모 자식들 간의 관계의 개수
		int m = Integer.parseInt(br.readLine());
		
		parent = new ArrayList[n+1];
		
		for (int i = 0; i < n+1; i++) {
			parent[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			parent[a].add(b);
			parent[b].add(a);
		}
		res = -1;
		visited = new boolean[n+1];
		dfs(p,1);
		System.out.println(res);
	}
	private static void dfs(int x, int cnt) {
			
		visited[x] = true;
		for (int i : parent[x]) {
			if (i == q) {
				res = cnt;
				return;
			}
			if (!visited[i]) {
				visited[i] = true;
				dfs(i,cnt+1);
			}
		}

	}
	
}
