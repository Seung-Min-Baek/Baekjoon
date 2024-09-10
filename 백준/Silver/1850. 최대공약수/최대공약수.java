import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		long a = Long.parseLong(st.nextToken());
		
		long b = Long.parseLong(st.nextToken());

		long max = 0;
		long min = 0;
		if (a > b) {
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		}

		while (max % min != 0) {
			long p = max % min;
			max = min;
			min = p;
		}
		for (int i = 1; i <= min; i++) {
			sb.append("1");
		}
		System.out.println(sb.toString());
	}
}
