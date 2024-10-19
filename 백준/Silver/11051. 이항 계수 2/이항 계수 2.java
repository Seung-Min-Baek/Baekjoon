import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		
		int[][] combi = new int[n+1][n+1];
//		  k 0  1  2  3  4  5 
//		n
//		1 	1  1
//		2	1  2  1
//		3	1  3  3  1
//		4	1  4  6  4  1
//		5	1  5  10 10 5  1
		
		// nC0 은 어떤 n이던 값이 1이므로
		for (int i = 1; i < combi.length; i++) {
			combi[i][0] = 1;
		}
		// 1C1은 1. 앞의 수가 없으므로 채워준다.
		combi[1][1] = 1;
		
		// 조합별 칸 채우기
		for (int i = 2; i < combi.length; i++) {
			for (int j = 1; j < i+1; j++) {
				// 각 행의 마지막 수는 무조건 1로 채운다.
				if (j == i+1) {
					combi[i][j] = 1;
				// 아니면 조건에 따라 칸 채우기
				// 2C1 = 1C0 + 1C1
				}else {
					combi[i][j] = combi[i-1][j-1] + combi[i-1][j];
					combi[i][j] = combi[i][j] % 10007;
				}
			}
		}
		
		System.out.println(combi[n][k]);
		
	}
}
