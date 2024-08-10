
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int guessMax = 0;
		int guessMaxp = 0;
		int[] cake = new int[L+1];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if (guessMax< k-p) {
				guessMax = k-p;
				guessMaxp = i;
			}
			
			for (int j = p; j <=k; j++) {
				if (cake[j]==0)
					cake[j] = i;
			}
		}
		int[] count = new int[n+1];
		for (int i = 0; i < cake.length; i++) {
			count[cake[i]]++;
		}
		int max = 0;
		int maxp = 0;
		for (int i = 1; i < count.length; i++) {
			if (max< count[i]) {
				max = count[i];
				maxp = i;
			}
		}
		System.out.println(guessMaxp);
		System.out.println(maxp);
	}
}
