import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] friend = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					friend[i][j] = 0;
				} else {
					friend[i][j] = 10000001;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friend[a][b] = friend[b][a] = 1;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <=n; j++) {
					if (friend[i][j] > friend[i][k] + friend[k][j]) {
						friend[i][j] = friend[i][k] + friend[k][j];
					}
				}
			}
		}

		int Min = Integer.MAX_VALUE;
		int Answer = -1;
		for (int i = 1; i <=n; i++) {
			int temp = 0;
			for (int j = 1; j <= n; j++) {
				temp = temp + friend[i][j];
			}
			if (Min > temp) {
				Min = temp;
				Answer = i;
			}
		}
		
		System.out.println(Answer);
	}
}
