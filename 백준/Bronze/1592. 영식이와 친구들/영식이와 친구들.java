import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] count = new int[n];

		int increase = 0;
		count[increase] = 1;
		while (true) {
			if (count[increase] == m)
				break;
			if (count[increase] % 2 == 1) {
				increase = (increase + l) % n;
			} else
				increase = (increase - l + n) % n;

			count[increase]++;
		}
		
		int sum =0;
		for (int i = 0; i < count.length; i++) {
			sum += count[i];
		}
		System.out.println(sum-1);

	}
}
