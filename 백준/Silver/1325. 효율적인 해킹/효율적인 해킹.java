import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] trust;
	static int n, m;
	static int[] num;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// computer 개수
		n = Integer.parseInt(st.nextToken());
		// 간선 수
		m = Integer.parseInt(st.nextToken());

		// 신뢰하는 관계 리스트에 저장
		trust = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			trust[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			trust[y].add(x);
		} // 입력 끝

		// 해킹할 수 있는 컴퓨터 개수 각 컴퓨터마다 저장
		num = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			cnt = 0;
			num[i] = dfs(i);
		}
		// max 값 찾기
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, num[i]);
		}
		for (int i = 1; i <= n; i++) {
			if (num[i] == max) {
				System.out.print(i + " ");
			};
		}
		
		
	}// main

	private static int dfs(int start) {

		visited[start] = true;
		for (int i : trust[start]) {
			if (!visited[i]) {
				visited[i] = true;
				cnt++;
				dfs(i);
			}
		}
		return cnt;
	}
}
