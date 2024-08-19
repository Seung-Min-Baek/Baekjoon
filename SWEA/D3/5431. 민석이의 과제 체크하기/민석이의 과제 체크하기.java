import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <=t; test++) {
			String [] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);
			
			String[] liney = br.readLine().split(" ");
			boolean[] arr = new boolean[n+1];
			for (int i = 0; i < k; i++) {
				int p = Integer.parseInt(liney[i]);
				arr[p] = true;
			}
			System.out.print("#" + test + " ");
			for (int i = 1; i < n+1; i++) {
				if (!arr[i]) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
		
	}
}
