import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] num;
	static int cnt;
	static int n, s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		num = new int[n];
		cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Tracking(0, 0);
		if (s==0) { // s가 0인 경우는 공집합도 포함되므로
			cnt -=1;
		}
		System.out.println(cnt);

	}

	static void Tracking(int depth, int sum) {
		if (depth == n) { //깊이가 n이면 리턴
			if (sum == s) {
				cnt++;
			}
			return;
		}

		Tracking(depth+1, sum + num[depth]);
		Tracking(depth+1,sum);
		

	}
}
