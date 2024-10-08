import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, root, delNode,cnt;
	static boolean[] visited;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		tree = new ArrayList[n];
		visited = new boolean[n];
		for (int i = 0; i < tree.length; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < tree.length; i++) {
			int a = Integer.parseInt(st.nextToken());

			// 루트노드가 아니면 인접 리스트에 추가
			if (a != -1) {
				tree[i].add(a);
				tree[a].add(i);
			} else {
				root = i;
			}
		}
		// 삭제할 노드 번호
		delNode = Integer.parseInt(br.readLine());
		// 삭제할 노드 번호가 root 노드이면 리프노드의 개수는 0개이다.
		if (delNode == root) {
			System.out.println(0);
		} else {
			cnt =0;
			dfs(root);
			System.out.println(cnt);
		}
	}

	private static void dfs(int i) {
		
		int child = 0;
		visited[i] = true;
		for (Integer node : tree[i]) {
			if (!visited[node] && node != delNode) {
				child++;
				dfs(node);
			}
		}
		if (child == 0) {
			cnt++;
		}
	}
}
