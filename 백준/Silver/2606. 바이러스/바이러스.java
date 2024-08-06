import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int compnum = Integer.parseInt(br.readLine());
		int netnum = Integer.parseInt(br.readLine());

		// 초기화
		A = new ArrayList[compnum + 1];
		visited = new boolean[compnum + 1];
		for (int i = 0; i < A.length; i++) {
			A[i] = new ArrayList<>();
		}
		// 인접 리스트 채우기
		for (int i = 0; i < netnum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int top = Integer.parseInt(st.nextToken());
			int bot = Integer.parseInt(st.nextToken());
			A[top].add(bot);
			A[bot].add(top);
		}

		// 작은번호부터 탐색하기 위해 정렬
		for (int i = 0; i < compnum; i++) {
			Collections.sort(A[i]);

		}

		System.out.println(BFS(1)-1);
	}

	static int BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		int count = 0;

		if (visited[start])
			return count;
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int n = queue.poll();
			count++;
			for (int i : A[n]) {
				if (visited[i] == false) {
					queue.add(i);
					visited[i] = true;
				}
			}

		}
		return count;
	}
}
