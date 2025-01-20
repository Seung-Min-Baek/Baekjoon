import java.util.*;

class Solution {
    static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static boolean[][] visited;
	static int[] island;
	static char[][] map;
	static int cnt;
    
    public ArrayList<Integer> solution(String[] maps) {
        map = new char[maps.length][];
		
		for (int i = 0; i < maps.length; i++) {
			map[i] = maps[i].toCharArray();
		}
		
		visited = new boolean[map.length][map[0].length];
		
		ArrayList<Integer> map_cnt = new ArrayList<Integer>(); 
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != 'X' && !visited[i][j]) {
					cnt = 0;
					dfs(i,j);
					map_cnt.add(cnt);
				}
			}
		}
		Collections.sort(map_cnt);
		if(map_cnt.size()==0){
            map_cnt.add(-1);
            return map_cnt;
        }
        else
		    return map_cnt;
        
    }
    private static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt += map[r][c]-'0';
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (0<=nr && nr<map.length && 0<=nc && nc<map[0].length && map[nr][nc]!='X' && !visited[nr][nc]) {
				dfs(nr,nc);
			}
			
		}
		
	}
}