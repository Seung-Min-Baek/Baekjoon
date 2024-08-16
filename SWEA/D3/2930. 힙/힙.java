import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			int n = Integer.parseInt(br.readLine());

			// 연산 1 : 2개의 자연수 -> 뒤의 자연수를 최대 힙에 추가하는 연산임
			// 연산 2 : 1개의 자연수 -> 현재 최대 힙의 루트 노드 출력, 해당 노드 삭제하는 연산

			PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
				return o2 - o1;
			});
			
			System.out.print("#"+test+" ");
			for (int i = 0; i < n; i++) {

				st = new StringTokenizer(br.readLine());

				int num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					int x = Integer.parseInt(st.nextToken());
					pq.add(x);
				} else if (num == 2) {
					if (pq.isEmpty()) 
						System.out.print(-1+" ");
					else
						System.out.print(pq.poll() + " ");
				}

			}
			System.out.println();
		}
	}
}
