import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] nr = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] nc = { 0, 0, 1, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][n];
		int[][] newMap = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = line[j];
			}
		}

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				if (Character.isDigit(map[r][c])) {
					int bombPower = map[r][c] - '0';
					newMap[r][c] = -1;
					for (int k = 0; k < 8; k++) {
						int dr = r + nr[k];
						int dc = c + nc[k];
						
						if (0 <= dr && dr < n && 0 <= dc && dc < n && newMap[dr][dc] != -1) {
							newMap[dr][dc] += bombPower;
						}
					}
				}
			}
		}

		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap.length; j++) {
				if(newMap[i][j] == -1) {
					map[i][j] = '*';
				} else if (newMap[i][j] >= 10) {
					map[i][j] = 'M';
				} else {
					map[i][j] = (char) (newMap[i][j] + '0');
				}
			}
		}

		for (int i = 0; i < newMap.length; i++) {
			for (int j = 0; j < newMap.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
