import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 동전 개수
		int n = Integer.parseInt(st.nextToken());
		// 동전 가치
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n+1];
		int[] cnt = new int[k+1];
		cnt[0]= 1;
		
		for (int i = 1; i <= n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		/**
         *     0   1   2   3   4   5   6   7   8   9   10
         * 1   1   1   1   1   1   1   1   1   1   1   1
         * 2   1   1   2   2   3   -3-   4   4   5   5   6
         * 5   +1+   1   2   2   3   *4*   5   6   7   8   10
         */
		
		for (int i = 1; i <= n; i++) {
			for (int j = coin[0]; j <= k; j++) {
				// 5원이면 index 5부터 시작
				if (j<coin[i]) {
					continue;
				}
				// cnt(자기 자신) + cnt(자기 자신 - 현재 동전값)
				cnt[j] = cnt[j]  + cnt[j-coin[i]];
			}
		}
		System.out.println(cnt[k]);
	}
}
