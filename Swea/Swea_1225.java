import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			int t = Integer.parseInt(br.readLine());

			int[] arr = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < arr.length; i++) {
				queue.add(arr[i]);
			}

			int num = 1;
			while (!queue.contains(0)) {
				int first = queue.poll();
				if (first - num < 0)
					queue.add(0);
				else
					queue.add(first - num);

				if (num == 5) {
					num = 0;
				}
				num++;
			}
			System.out.printf("#%d ", test);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
}
