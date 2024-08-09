import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Swea_1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {

			int n = Integer.parseInt(br.readLine());

			String[] line = br.readLine().split(" ");
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(line[i]);
			}

			for (int i = 0; i < arr.length; i++) {

				int data = arr[i];

				int j;

				for (j = i - 1; j >= 0 && arr[j] > data; j--) {
					arr[j + 1] = arr[j];
				}
				arr[j + 1] = data;
			}
			System.out.printf("#%d ",test);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}

	}
}
