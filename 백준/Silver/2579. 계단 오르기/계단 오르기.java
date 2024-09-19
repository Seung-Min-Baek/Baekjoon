import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] pt, res;
	static int max, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		pt = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			pt[i] = Integer.parseInt(br.readLine());
		}

		res = new int[n + 1];
		if (n == 1) {
			System.out.println(pt[1]);
			return;
		}
		// 계단이 한칸일 경우
		res[1] = pt[1];
		if (n>=2) {
			res[2] = pt[1] + pt[2];
		}
		if (n>=3) {
			res[3] = Math.max(pt[1], pt[2]) + pt[3];
			
		}
		for (int i = 4; i <= n; i++) {
			res[i] = Math.max(res[i-3] + pt[i-1],res[i-2]) + pt[i];
		}
		System.out.println(res[n]);
	}
}
