import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < t; test++) {
			// 층
			int k = Integer.parseInt(br.readLine());
			// 호수
			int n = Integer.parseInt(br.readLine());
			// 둘 중 최댓값으로 배열만들기
			int max = k;
			max = Math.max(max, n);
			int[][] apartment = new int[max+1][max+1];
			
//		      n	 1	2  3  4  5
//			k
//			0	 1	2  3  4	 5
//			1	 1  3  6  10 15
//			2    1  4  10 20 35
//			3    1  5  15 35 70
			
			for (int i = 1; i < apartment.length; i++) {
				apartment[0][i] = i;
			}
			
			for (int i = 1; i < apartment.length; i++) {
				for (int j = 1; j < apartment[0].length; j++) {
					apartment[i][j] = apartment[i-1][j] + apartment[i][j-1];
				}
			}
			System.out.println(apartment[k][n]);
		}
	}
}
