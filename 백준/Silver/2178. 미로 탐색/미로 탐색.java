import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		
		map = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		visited = new boolean[n][m];
		bfs(0, 0);
		System.out.println(map[n-1][m-1]);
		
	}
	
	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.add(new int[] {r,c});
		
		while(!queue.isEmpty()) {
			int[] currNode = queue.poll();
			int currR = currNode[0];
			int currC = currNode[1];
			
			for(int d = 0; d<4; d++) {
				
				int nr = currR+dr[d];
				int nc = currC+dc[d];
				
					if(0<=nr && nr<map.length && 0<=nc && nc<map[0].length && map[nr][nc]==1 && !visited[nr][nc]) {
						queue.add(new int[] {nr, nc});
						visited[nr][nc] = true;
						map[nr][nc] += map[currR][currC];
					}
			}		
		}
	}

}
