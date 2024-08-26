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
		visited = new boolean[n];
		
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
		
		// 각 정점에서 DFS 시작
		for (int i = 0; i < n; i++) {
			// 방문 초기화
			visited = new boolean[n];
			// 카운트 초기화
			count = false;
			// DFS 시작
			dfs(i, 1);
			// 연결된 깊이가 5인 경우가 있다면 종료
			if (count) break;
		}
		
		// 결과 출력
		if (count) 
			bw.write("1\n");
		else
			bw.write("0\n");
		
		bw.flush();
		bw.close();
	}
	
	static void dfs(int x, int cnt) {
		if (count) return;  // 이미 연결된 깊이가 5인 경로가 발견되었으므로 더 이상 탐색할 필요 없음
		
		if (cnt == 5) {
			count = true;
			return;
		}
		
		visited[x] = true;
		
		for (int i : arr[x]) {
			if (!visited[i]) {
				dfs(i, cnt + 1);
			}
		}
		
		visited[x] = false; // 백트래킹
	}
}
