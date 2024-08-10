import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] coord = new int[1001][1001];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dx = Integer.parseInt(st.nextToken());
			int dy = Integer.parseInt(st.nextToken());
			
			for (int r = x; r < x+dx; r++) {
				for (int c = y; c < y+dy; c++) {
					coord[r][c] = i;
				}
			}
		}
		int[] count = new int[n+1];
		for (int i = 0; i < coord.length; i++) {
			for (int j = 0; j < coord.length; j++) {
				count[coord[i][j]]++;
			}
		}
		for (int i = 1; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}
