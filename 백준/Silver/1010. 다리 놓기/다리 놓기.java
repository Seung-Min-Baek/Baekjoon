import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < T; test++) {
			String[] line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			
			int[][] bridge = new int[m+1][m+1];
			
			for (int i = 1; i < bridge.length; i++) {
				bridge[i][0] = 1;
			}
			
			bridge[1][1] = 1;
			
			for (int i = 2; i < bridge.length; i++) {
				for (int j = 1; j < i+1; j++) {
					if (j == i) {
						bridge[i][j] =1;
					}else {
						bridge[i][j] = bridge[i-1][j-1] + bridge[i-1][j];
					}
				}
			}
			System.out.println(bridge[m][n]);
		}
	}
}
