import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {

		int end;
		int dist;

		public Node(int end, int dist) {
			super();
			this.end = end;
			this.dist = dist;

		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}

	static int n, m, r;
	static int[] items, distance;
	static boolean[] visited;
	static ArrayList<Node>[] road;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 지역의 개수
		m = Integer.parseInt(st.nextToken()); // 수색범위
		r = Integer.parseInt(st.nextToken()); // 길의 개수

		items = new int[n + 1]; // index 1부터 지역의 아이템 수를 자장할 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		road = new ArrayList[n + 1]; // 시작, 끝, 거리 저장할 길 배열
		for (int i = 1; i < road.length; i++) {
			road[i] = new ArrayList<>();
		}

		for (int i = 0; i < r; i++) { // r번 반복
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			road[start].add(new Node(end, dist));
			road[end].add(new Node(start, dist)); // 양방향이므로 시작, 끝 모두 넣어준다.
		} // 입력 완료

		int maxValue = 0;

		for (int i = 1; i <= n; i++) {
			maxValue = Math.max(maxValue, dijstra(i)); // 최댓값 갱신
		}
		
		System.out.println(maxValue);
	}

	public static int dijstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[n + 1]; // 새로운 start 들어올 떄마다 방문배열 초기화
		distance = new int[n + 1]; // 거리들의 합을 저장할 거리 배열
		Arrays.fill(distance, Integer.MAX_VALUE); // 최단 거리이기 떄문에 max_value로 한다.
		distance[start] = 0;
		
		int max = 0;

		pq.add(new Node(start, 0)); // 시작 지점은 자기 자신과 거리가 0

		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();
			
			if(!visited[curr.end])
				visited[curr.end] = true;
				
			for (Node node : road[curr.end]) { // 끝 지점 꺼내서 인접 노드 삽입
				if (!visited[node.end] && distance[node.end] > distance[curr.end] + node.dist) { // 방문 x 
					distance[node.end] = distance[curr.end] + node.dist; // 배열에 저장되어 있는 거리 < 이전 노드까지의 거리+현재 거리 면 갱신
					pq.add(new Node(node.end, distance[node.end])); // 노드 삽입
				}
			}

		}
		for (int i = 0; i < distance.length; i++) { // 거리 배열 안의 값 중 m 보다 작거나 같으면 더하기.
			if(visited[i] && distance[i] <= m )
			max += items[i]; 
		}

		return max;

	}
}
