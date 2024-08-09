import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			String[] strarr = br.readLine().split("");

			int count = 0;
			for (int i = strarr.length - 1; i >0; i--) {
				if(!strarr[i].equals(strarr[i-1])) {
					count++;
				}
				if (i==1 && strarr[i-1].equals("1")) {
					count++;
				}
			}
			System.out.println("#"+ test + " " +count);
		}
	}
}
