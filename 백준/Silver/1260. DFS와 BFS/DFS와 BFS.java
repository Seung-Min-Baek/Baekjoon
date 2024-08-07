
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visit;
	static int[][] arr;
	static Queue<Integer> q = new LinkedList<>();
	static int n;
	static int m;
	static int v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력값 한줄 받아서 string 배열에 넣기
		// 노드 개수
		n = Integer.parseInt(st.nextToken());
		// 간선의 개수
		m = Integer.parseInt(st.nextToken());
		// 노드의 시작 번호
		v = Integer.parseInt(st.nextToken());

		// 노드 간의 간선 표현 해 줄 arr 배열
		arr = new int[n + 1][n + 1];
		// 방문 했는지를 구분하기 위한 vist 배열
		visit = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// 연결된 노드의 번호
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 노드 간의 간선을 표현해주기 위한 표
			arr[a][b] = arr[b][a] = 1;
		}
		dfs(v);
		System.out.println();
		visit = new boolean[n + 1];
		bfs(v);

	}
	// 깊이 우선 탐색
	public static void dfs(int v) {
		if (visit[v]) {
			return;
		}
		visit[v] = true;
		System.out.printf(v + " ");
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[v][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	// 너비 우선 탐색
	// 시작점 v
	public static void bfs(int v) {
		q = new LinkedList<>();
		// 시작점 q에 추가
		q.add(v);
		// 시작점 방문
		visit[v] = true;
		
		System.out.print(v + " ");

		// q가 비어있을 떄까지 반복문
		while (!q.isEmpty()) {

			// 가장 먼저 넣어진 v 부터 빠짐.
			int temp = q.poll();

			for (int i = 1; i < arr.length; i++) {
				// temp와 연결되어 있고, 방문이 false이면
				if (arr[temp][i] == 1 && !visit[i]) {
					// 큐에 올림
					q.add(i);
					// 방문 true
					visit[i] = true;
					System.out.print(i + " ");
				}
			}

		}

	}

}
