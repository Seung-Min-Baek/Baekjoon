import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {
	static int n,m;
	static int[][] a;
	final static int INF = 987654321;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		a = new int[n+1][n+1];
		
		// 인접 행렬 초기화
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < n+1; j++) {
				if (i == j) 
					a[i][j] = 0;
				else
					a[i][j] = INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			if (a[A][B] >W) {
				a[A][B] = W;
			}
		}// 입력 끝.
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (a[i][j] > a[i][k] + a[k][j]) {
						a[i][j] = a[i][k] + a[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n; j++) {
				if (a[i][j] == INF) {
					System.out.print("0 ");
				}else {
					System.out.print(a[i][j] + " ");
				}
			}
			System.out.println();
		}
		
		
		
	}
}
