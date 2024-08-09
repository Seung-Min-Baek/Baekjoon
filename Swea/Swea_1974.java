import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		out: for (int test = 1; test <= T; test++) {

			int n = 9;

			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			// 합이 45가 아니면 겹치는 숫자가 있는것
			for (int r = 0; r < n; r++) {
				// 가로
				int rowsum = 0;
				// 세로
				int colsum = 0;

				for (int c = 0; c < n; c++) {
					rowsum += arr[r][c];
					colsum += arr[c][r];
				}
				if (rowsum != 45) {
					System.out.printf("#%d %d\n", test, 0);
					continue out;
				}
				if (colsum != 45) {
					System.out.printf("#%d %d\n", test, 0);
					continue out;
				}
			}
			// 3x3
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {

					int boxsum = 0;
					for (int r = 3 * i; r <= 3 * i + 2; r++) {
						for (int c = 3 * j; c <= 3 * j + 2; c++) {
							boxsum += arr[r][c];
						}
					}
					if (boxsum != 45) {
						System.out.printf("#%d %d\n", test, 0);
						continue out;
					}
				}
			}
			System.out.printf("#%d %d\n", test, 1);

		}
	}
}
