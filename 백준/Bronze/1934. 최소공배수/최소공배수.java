import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 0; test < t; test++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int max = 0;
			int min = 0;
			if (a > b) {
				max = a;
				min = b;
			} else {
				max = b;
				min = a;
			}

			while (max % min != 0) {
				int p = max % min;
				max = min;
				min = p;
			}
			int x = a/min;
			int y = b/min;
			
			System.out.println(x * y * min);
		}
	}
}
