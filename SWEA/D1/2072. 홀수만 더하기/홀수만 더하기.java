import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= t; test++) {
			String[] line = br.readLine().split(" ");
			
			int sum = 0;
			int[] arr = new int[10];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(line[i]);
				if (arr[i] %2 ==1) {
					sum+= arr[i];
				}
			}
			System.out.println("#" + test + " " + sum);
			
		}
	}
}
