import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		boolean[] visited = new boolean[21];
		long[] f = new long[21];
		f[0] = 1;
		for (int i = 1; i < 21; i++) {
			f[i] = f[i - 1] * i;
		}
		
		if (num == 1) {
			long k = Long.parseLong(st.nextToken());
			
			for (int i = 0; i < n; i++) {
				for (int j = 1; j <=n; j++) {
					// 순열에 이미 존재하는 숫자면 넘어가기
					if (visited[j]) {
						continue;
					}
					// 팩토리얼 값이 k보다 작으면 k값에 빼주기
					if (f[n-i-1]<k) {
						k-= f[n-i-1];
					// 크면 해당 원소를 찾은것이므로 배열에 넣어주고, 방문 체크 후 다음 체크
					}else {
						arr[i] =j;
						visited[j] = true;
						break;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
		}else {
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			long ans = 1L;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < arr[i]; j++) {
					if (!visited[j]) {
						ans += f[n-i-1];
					}
				}
				visited[arr[i]] = true;
			}
			System.out.println(ans);
		}

	}
}
