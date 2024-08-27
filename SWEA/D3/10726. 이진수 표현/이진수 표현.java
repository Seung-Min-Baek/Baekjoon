import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			int cnt = 0;

			char[] binarynum = Integer.toBinaryString(m).toCharArray();
			if (n < binarynum.length) {

				for (int i = binarynum.length - 1; i >= binarynum.length - n; i--) {
					if (binarynum[i] == '1') {
						cnt++;
					}
				}
			}else {
				for (int i = binarynum.length - 1; i >= 0; i--) {
					if (binarynum[i] == '1') {
						cnt++;
					}
				}
			}

			if (cnt == n)
				System.out.println("#" + test + " ON");
			else
				System.out.println("#" + test + " OFF");

		}
	}
}
