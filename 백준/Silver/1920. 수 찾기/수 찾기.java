import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] a;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a.length; i++)
			a[i] = Integer.parseInt(st.nextToken());

		// 정렬
		Arrays.sort(a);

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());

			boolean booly = search(num);
			if (booly) System.out.println(1);
			else System.out.println(0);
		}
	}

	static boolean search(int x) {
		int L = 0;
		int R = n - 1;

		// 이진탐색 시작
		while (L <= R) {
			int mid = (L + R) / 2;

			if (x == a[mid])
				return true;
			// 찾으려는 수 < 중간값
			else if (x < a[mid])
				R = mid - 1;
			// 중간값 < 찾으려는 수 
			else if (a[mid] < x)
				L = mid + 1;

		}
		return false;
	}
}
