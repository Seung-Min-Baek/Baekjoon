import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static boolean count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n];
		// 배열 각 방에 리스트 열어주기
		for (int i = 0; i < n; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int relation = 0; relation < m; relation++) {
			st = new StringTokenizer(br.readLine());
			int rela = Integer.parseInt(st.nextToken());
			int tion = Integer.parseInt(st.nextToken());

			arr[rela].add(tion);
			arr[tion].add(rela);
		}
		// 연속으로 연결된 노드가 최대일 때를 찾으면 되므로
		// 모든 노드를 시작점으로 해서 dfs 순회
		for (int i = 0; i < arr.length; i++) {

			visited = new boolean[n];
			count = false;
			dfs(i, 1);
			
			// cnt가 5개이면 다음 노드 순회 필요 없음.
			if (count)
				break;

		}
		if (count)
			bw.write("1\n");
		else
			bw.write("0\n");

		bw.flush();
		bw.close();
	}

	static void dfs(int x, int cnt) {
		if(count) return;
		
		if (cnt == 5) {
			count = true;
			return;
		}
		// 방문
		visited[x] = true;

		for (int i : arr[x]) {
			if (!visited[i]) {
				dfs(i, cnt + 1);
			}
		}
		// 처음에 visited[x] = true 했으므로 방문 해제
		visited[x] = false;
	}
}
