import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_4613 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			char[][] vocab = new char[n][m];
			for (int i = 0; i < n; i++) {
				String line = br.readLine();
				vocab[i] = line.toCharArray();
			}
			System.out.println(Arrays.deepToString(vocab));
		}
	}
}

//	static int count(char[] c) {
//		
//		return num;
//	}
