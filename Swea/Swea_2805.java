import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[n][n];
			for (int i = 0; i < arr.length; i++) {
				String str = br.readLine();
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
			}

			int sum = 0;

			int r = n / 2 + 1; // 3
			int c = 0;
			int num = 0;
			// 위의 부분 더해서 출력
			for (int i = 0; i < r; i++) {
				for (int j = r - num - 1; j <= r + num - 1; j++) {
					sum += arr[i][j];
				}
				num++;
			}
			num-=2;
			for (int i = r; i < arr.length; i++) {
				for (int j = r - num - 1; j <= r + num - 1; j++) {
					sum += arr[i][j];
				}
				num--;

			}
			System.out.printf("#%d %d\n",test,sum);
		}

	}
}
