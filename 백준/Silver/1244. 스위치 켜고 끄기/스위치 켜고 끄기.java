import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] swich;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		swich = new int[num];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < swich.length; i++) {
			swich[i] = Integer.parseInt(st.nextToken());
		}

		int people = Integer.parseInt(br.readLine());

		for (int i = 0; i < people; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			if (sex == 1) {
				for (int j = 0; j < num; j++) {
					if ((j + 1) % n == 0) {
						swich[j] = swich[j] == 0 ? 1 : 0;
					}
				}
			} else {
				swich[n - 1] = swich[n - 1] == 0 ? 1 : 0;
				for (int j = 1; j < num / 2; j++) {
					if (n - 1 + j >= num || n - 1 - j < 0) {
						break;
					}
					if (swich[n - 1 - j] == swich[n - 1 + j]) {
						swich[n - 1 - j] = swich[n - 1 - j] == 0 ? 1 : 0;
						swich[n - 1 + j] = swich[n - 1 + j] == 0 ? 1 : 0;
					}
					else break;
				}
			}
		}

		for (int i = 0; i < swich.length; i++) {
			System.out.print(swich[i] + " ");
			if ((i + 1) % 20 == 0) // 20개의 스위치마다 줄바꿈 추가
				System.out.println();

		}
	}
}
