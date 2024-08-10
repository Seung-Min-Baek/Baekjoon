
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int count =0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int k = i/j;
				if (i%j==0 && j<=k) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
