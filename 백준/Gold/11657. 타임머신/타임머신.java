import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class City {
		int end;
		int weight;

		public City(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
	}

	static int n, m;
	static ArrayList<City>[] a;
	static long[] dist;
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		a = new ArrayList[n + 1];
		dist = new long[n + 1];
		for (int i = 1; i < a.length; i++) {
			a[i] = new ArrayList<>();
			dist[i] = INF;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			a[A].add(new City(B, C));
		}

		StringBuilder sb = new StringBuilder();
		// 음수 사이클 발생하여 true로 return되면 -1 출력
		if (bellmanFord()) {
			sb.append("-1\n");
		} else {
			for (int i = 2; i <= n; i++) {
				if (dist[i] == INF) {
					sb.append("-1\n");
				}else {
					sb.append(dist[i] + "\n");
				}
			}
		}
		System.out.println(sb);
	}

	private static boolean bellmanFord() {
		dist[1] = 0; // 시작점은 0으로 초기화
		boolean update = false;

		// (정점의 개수 -1)번 동안 최단거리 초기화 작업을 반복함.
		for (int i = 1; i < n; i++) {
			update = false;

			// 최단거리 초기화.
			for (int j = 1; j <= n; j++) {
				for (City city : a[j]) {
					if (dist[j] != INF && dist[city.end] > dist[j] + city.weight) {
						dist[city.end] = dist[j] + city.weight;
						update = true;
					}
				}
			}
			// 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문 종료
			if (!update) {
				break;
			}
		}

		// (정점의 개수 -1)번까지 계속 업데이트가 발생하였을 경우
		// (정점의 개수)번도 업데이트 발생하면 음수 사이클 일어난 것.
		if (update) {
			for (int j = 1; j <= n; j++) {
				for (City city : a[j]) {
					if (dist[j] != INF && dist[city.end] > dist[j] + city.weight) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
