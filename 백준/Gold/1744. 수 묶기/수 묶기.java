import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> plusq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minusq = new PriorityQueue<>();

		int one = 0;
		int zero = 0;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > 1) {
				plusq.add(num);
			} else if (num == 1) {
				one++;
			} else if (num == 0) {
				zero++;
			} else {
				minusq.add(num);
			}
		}
		int sum = 0;
		// 양수
		while (plusq.size() > 1) {
			int x = plusq.poll();
			int y = plusq.poll();
			sum += x * y;
		}
		if(!plusq.isEmpty()) {
			sum += plusq.poll();
		}
		//음수
		while (minusq.size() > 1) {
			int x = minusq.poll();
			int y = minusq.poll();
			sum += x * y;
		}
		if (!minusq.isEmpty()) {
			if(zero==0) {
				sum += minusq.poll();
			}
		}
		
		// 1 처리
		sum +=one;
		System.out.println(sum);

	}
}
