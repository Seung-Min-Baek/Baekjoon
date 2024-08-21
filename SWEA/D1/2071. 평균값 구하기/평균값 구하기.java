import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			String[] line = br.readLine().split(" ");

			double sum = 0;
			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(line[i]);
				sum += arr[i];
			}
			double avg = sum/10;
			System.out.printf("#%d %.0f\n",test,avg);

		}
	}
}
