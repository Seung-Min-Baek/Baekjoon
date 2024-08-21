import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static char[][] map;
	static int w;
	static int h;
	static int location_i;
	static int location_j;
	static int dir;
	// 상,하,좌,우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new char[w][h];

			for (int i = 0; i < w; i++) {
				char[] map_Line = br.readLine().toCharArray();
				for (int j = 0; j < h; j++) {
					map[i][j] = map_Line[j];
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						location_i = i;
						location_j = j;
					}
					if (map[i][j] == '^')
						dir = 0;
					else if (map[i][j] == 'v')
						dir = 1;
					else if (map[i][j] == '<')
						dir = 2;
					else if (map[i][j] == '>')
						dir = 3;

				}
			}

			int n = Integer.parseInt(br.readLine());
			char[] move = br.readLine().toCharArray();


			// move 시작
			for (int i = 0; i < move.length; i++) {
				if (move[i] == 'S') {
					shoot();
				} else if (move[i] == 'U') {
					up();
				} else if (move[i] == 'D') {
					down();
				} else if (move[i] == 'L') {
					left();
				} else if (move[i] == 'R') {
					right();
				}
			}
			System.out.print("#" + test + " ");
			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void shoot() {
		// 포탄이 맞는 위치
		int nr = location_i + dr[dir];
		int nc = location_j + dc[dir];

		if (0 <= nr && 0 <= nc && nr < w && nc < h) {
			if (map[nr][nc] == '*') {
				map[nr][nc] = '.';
				return;
			}
			while (map[nr][nc] == '.' || map[nr][nc] == '-') {
				nr += dr[dir];
				nc += dc[dir];
				
				if (!(0 <= nr && 0 <= nc && nr < w && nc < h))
					return;
			}
			if (map[nr][nc] == '*') {
				map[nr][nc] = '.';
				return;
			}
		} else
			return;
	}

	static void up() {
		// 전차가 바라보는 방향 : 위
		dir = 0;
		map[location_i][location_j] = '^';
		int prev_loca_i = location_i;
		int prev_loca_j = location_j;
		
		int nr = location_i + dr[dir];
		int nc = location_j + dc[dir];
		// 한 칸 위가 평지라면 그 칸으로 이동
		if (0 <= nr && 0 <= nc && nr < w && nc < h && map[nr][nc] == '.') {
			location_i = nr;
			location_j = nc;
			map[prev_loca_i][prev_loca_j] = '.';
			map[location_i][location_j] = '^';
			return;
		} else
			return;
	}

	static void down() {
		// 전차가 바라보는 방향 : 아래
		dir = 1;
		map[location_i][location_j] = 'v';
		int prev_loca_i = location_i;
		int prev_loca_j = location_j;
		
		int nr = location_i + dr[dir];
		int nc = location_j + dc[dir];
		// 한 칸 위가 평지라면 그 칸으로 이동
		if (0 <= nr && 0 <= nc && nr < w && nc < h && map[nr][nc] == '.') {
			location_i = nr;
			location_j = nc;
			map[prev_loca_i][prev_loca_j] = '.';
			map[location_i][location_j] = 'v';
			return;
		} else
			return;
	}

	static void left() {
		// 전차가 바라보는 방향 : 좌
		dir = 2;
		map[location_i][location_j] = '<';
		int prev_loca_i = location_i;
		int prev_loca_j = location_j;
		
		int nr = location_i + dr[dir];
		int nc = location_j + dc[dir];
		// 한 칸 위가 평지라면 그 칸으로 이동
		if (0 <= nr && 0 <= nc && nr < w && nc < h && map[nr][nc] == '.') {
			location_i = nr;
			location_j = nc;
			map[prev_loca_i][prev_loca_j] = '.';
			map[location_i][location_j] = '<';
			return;
		} else
			return;
	}

	static void right() {
		// 전차가 바라보는 방향 : 우
		dir = 3;
		map[location_i][location_j] = '>';
		int prev_loca_i = location_i;
		int prev_loca_j = location_j;
		
		int nr = location_i + dr[dir];
		int nc = location_j + dc[dir];
		// 한 칸 위가 평지라면 그 칸으로 이동
		if (0 <= nr && 0 <= nc && nr < w && nc < h && map[nr][nc] == '.') {
			location_i = nr;
			location_j = nc;
			map[prev_loca_i][prev_loca_j] = '.';
			map[location_i][location_j] = '>';
			return;
		} else
			return;
	}
}
