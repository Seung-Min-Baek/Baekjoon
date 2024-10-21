import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());

		double[] stone = new double[m];
		double[] cases = new double[m];

		String[] line = br.readLine().split(" ");

		double sum1 = 0;
		for (int i = 0; i < stone.length; i++) {
			stone[i] = Integer.parseInt(line[i]);
			cases[i] = stone[i];
			sum1 += stone[i];
		}
		double sum2 = sum1;
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < cases.length; i++) {
			int j = 1;
			while (j != k) {
				stone[i] = stone[i] - 1;
				cases[i] = cases[i] * stone[i];
				j = j + 1;
			}
		}
		int p =1;
		while (p != k) {
			sum2 = sum2 - 1;
			sum1 = sum1 * sum2;
			p = p + 1;
		}

		double foll = 0;
		for (int i = 0; i < cases.length; i++) {
			foll = foll + cases[i];
		}
		
		System.out.println(foll/sum1);
	}
}
