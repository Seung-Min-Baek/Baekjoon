import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] student = new ArrayList[n + 1];

		for (int i = 1; i < student.length; i++) {
			student[i] = new ArrayList<Integer>();
		}

		int[] degree = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			student[a].add(b);
			degree[b]++;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i < degree.length; i++) {
			if (degree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int p = q.poll();
			sb.append(p).append(" ");
			for (int next : student[p]) {
				degree[next]--;
				if (degree[next] == 0) {
					q.add(next);
				}

			}

		}
		System.out.println(sb);
	}
}
