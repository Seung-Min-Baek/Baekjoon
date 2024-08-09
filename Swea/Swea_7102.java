import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7102 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] countingStar = new int[n+m+1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					countingStar[i+j]++;
				}
			}
			int max = 0;
			for (int i = 0; i < countingStar.length; i++) {
				if (max < countingStar[i]) {
					max = countingStar[i];
				}
			}
			System.out.print("#"+ test+" ");
			for (int i = 0; i < countingStar.length; i++) {
				if (max == countingStar[i]) {
					System.out.print(i+ " ");
				}
			}
			System.out.println();
		}
	}
}

