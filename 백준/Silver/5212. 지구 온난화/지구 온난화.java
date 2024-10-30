
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int r, c;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int up = r;
		int down = 0;
		int left = c;
		int right = 0;
		
		map = new char[r + 2][c + 2];

		for (char a[] : map) {
			Arrays.fill(a, '.');
		}

		for (int i = 1; i < r + 1; i++) {
			String[] line = br.readLine().split("");
			for (int j = 1; j < c + 1; j++) {
				map[i][j] = line[j - 1].charAt(0);
			}
		}

		
		
		for (int i = 1; i < r + 1; i++) {
			for (int j = 1; j < c + 1; j++) {

				if (map[i][j] == 'X') {
					int cnt = 0;
					for (int dir = 0; dir < 4; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						
						if (map[nr][nc] == '.') {
							cnt++;
						}
					}
					if (cnt >=3) {
						map[i][j] = 'S';
					}

				}
				if (map[i][j] == 'X') {
					up = Math.min(up, i);
					down = Math.max(down, i);
					left = Math.min(left,j);
					right = Math.max(right, j);
					
				}
			}
		}
		
		for (int i = up; i <= down; i++) {
			for (int j = left; j <= right; j++) {
				if (map[i][j] == 'S') 
					System.out.print('.');
				else
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

}
