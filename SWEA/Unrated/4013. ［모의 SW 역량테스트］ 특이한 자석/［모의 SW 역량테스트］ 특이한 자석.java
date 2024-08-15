import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int test = 1; test <= t; test++) {

			int k = Integer.parseInt(br.readLine());

			int[][] wheel = new int[4][8];

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j = 0; j < 8; j++) {
					wheel[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int wheel_num = Integer.parseInt(st.nextToken()) - 1;
				int direction = Integer.parseInt(st.nextToken());

				int[] rotation = new int[4];
				rotation[wheel_num] = direction;

				// 왼쪽 자성 검사
				for (int j = wheel_num - 1; j >= 0; j--) {

					if (wheel[j + 1][6] == wheel[j][2]) {
						break;
					} else {
						rotation[j] = -rotation[j + 1];
					}

				}
				// 오른쪽 자성 검사
				for (int j = wheel_num + 1; j < 4; j++) {

					if (wheel[j][6] == wheel[j - 1][2]) {
						break;
					} else {
						rotation[j] = -rotation[j - 1];
					}

				}
				// 입력받은 바퀴 돌리기
				for (int p = 0; p < 4; p++) {

					if (rotation[p] == 0) {
						continue;

					} else if (rotation[p] == 1) {

						int temp = wheel[p][7];

						for (int j = 6; j >= 0; j--)
							wheel[p][j + 1] = wheel[p][j];

						wheel[p][0] = temp;

					} else if (rotation[p] == -1) {

						int temp = wheel[p][0];

						for (int j = 1; j <= 7; j++)
							wheel[p][j - 1] = wheel[p][j];

						wheel[p][7] = temp;
					}
				}
			}
			int sum = 0;
			if (wheel[0][0] == 1) 
				sum += 1;
			if (wheel[1][0] == 1) 
				sum += 2;
			if (wheel[2][0] == 1) 
				sum += 4;
			if (wheel[3][0] == 1) 
				sum += 8;
			System.out.println("#" + test + " " + sum);
		}
	}
}
