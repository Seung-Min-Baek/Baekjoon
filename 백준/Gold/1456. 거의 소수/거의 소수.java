import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		// 소수 구하기
		long[] A = new long[10000001];
		for (int i = 2; i < A.length; i++) {
			A[i] = i;
		}
		// 1은 소수 아님.
//		visited[1] = true;
		// 2부터 시작 + 아리스토테네체의 해
		for (int i = 2; i <= Math.sqrt(A.length); i++) {
			if (A[i] != 0) {
				for (int j = i + i; j < A.length; j = j + i) {
					A[j] = 0;
				}
			}
		}
		int cnt = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] != 0) {
				long temp = A[i];
				while ((double)A[i] <= (double)b / (double)temp) {
					if ((double)A[i] >= (double)a / (double)temp) {
						cnt++;
					}
					temp *= A[i];
				}
			}
		}

		System.out.println(cnt);
	}
}
