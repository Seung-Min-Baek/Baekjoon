import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Swea_1859 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {

			int n = Integer.parseInt(br.readLine());

			String[] str = br.readLine().split(" ");
			int[] q = new int[n];
			for (int i = 0; i < str.length; i++) {
				q[i] = Integer.parseInt(str[i]);
			}
			// 10

			Queue<Integer> queue = new LinkedList<>();
			// [10]

			// 돈
			long money = 0;

			boolean switches = true;

			int max_index = 0;
			int low_index = 0;

			while (switches) {
				int max_num = 0;
				// 배열 내 최댓값 찾기
				for (int i = low_index; i < q.length; i++) {
					if (max_num < q[i]) {
						max_num = q[i];
						max_index = i;
					}
				}

				for (int i = low_index; i <= max_index; i++) {
					queue.add(q[i]);
					int buy = queue.poll();
					money = money - buy + max_num;
				}

				low_index = max_index + 1;
				
				if (max_index + 1 == q.length) {
					switches = false;
				}
			}
			System.out.printf("#%d %d\n", test, money);

		}

	}

}
