import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		radix_sort(arr, 5);
		for (int i = 0; i < n; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();

	}

	static void radix_sort(int[] arr, int max_size) {

		// num : 자리수
		int num = 1;
		int cnt = 0;
		// 새로 정렬된 배열이 들어갈 공간.
		int[] new_arr = new int[n];

		while (cnt != max_size) {
			int[] bucket = new int[10];
			// bucket에 각 자리수마다 있는 수 세기
			for (int i = 0; i < n; i++) {
				bucket[(arr[i] / num) % 10]++;
			}
			// 합으로 index 정렬
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			for (int i = n -1; i >= 0; i--) {
				new_arr[bucket[(arr[i] / num % 10)] - 1] = arr[i];
				bucket[(arr[i] / num) %10] --;
			}

			for (int i = 0; i < n; i++) {
				arr[i] = new_arr[i];
			}
			num = num *10;
			cnt++;
		}
	}
}
