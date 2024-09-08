import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] map;
	static int v, e;
	static boolean[] visited;
	static int[] color;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test = 0; test < t; test++) {
			st = new StringTokenizer(br.readLine());

			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			map = new ArrayList[v + 1];
			for (int i = 0; i < map.length; i++) {
				map[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < e; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				map[x].add(y);
				map[y].add(x);
			} // 입력 끝
				// 초기화
			visited = new boolean[v + 1];
			color = new int[v + 1];

			boolean div = true;
			for (int i = 1; i <= v; i++) {
				if (!visited[i]) {
					if (!bfs(i)) {
						div = false;
						break;
					}
				}
			}
			// true이면 이분 그래프
			if (div)
				System.out.println("YES");
			// false이면 이분 그래프 아님
			else
				System.out.println("NO");
		}
	}

	private static boolean bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		// 시작 지점 방문체크 후 색 1
		visited[start] = true;
		color[start] = 1;

		q.add(start);

		while (!q.isEmpty()) {
			int x = q.poll();
			// 다음 노드의 색 ( 1과 2 번갈아)
			int next_color = color[x] % 2 + 1;
			// 자식 노드들
			for (Integer i : map[x]) {
				// 아직 방문 안했으면 방문체크
				if (!visited[i]) {
					visited[i] = true;
					// 색 번갈아 지정
					color[i] = next_color;
					q.add(i);
					// 방문한 지점이 번갈아 지정하는 다음 색과 다르면 ( 방문한 지점이 내 색과 같으면)
				} else if (color[i] != next_color) {
					return false;
				}
			}
		}
		return true;
	}
}
