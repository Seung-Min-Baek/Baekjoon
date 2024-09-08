import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + "]";
		}
		
	}
	static int n;
	static double E;
	static boolean[] visited;
	static final double INF = Double.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= t; test++) {
			n = Integer.parseInt(br.readLine());
			
			Point[] points = new Point[n];
			
			visited = new boolean[n];
			// 선택한 최소 거리 저장.
			double[] dist = new double[n];
			
			for (int i = 0; i < n; i++) {
				dist[i] = INF;
			}
			
			StringTokenizer stx = new StringTokenizer(br.readLine());
			StringTokenizer sty = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int x = Integer.parseInt(stx.nextToken());
				int y = Integer.parseInt(sty.nextToken());
				points[i] = new Point (x,y);
			}
//			System.out.println(Arrays.deepToString(points));
			E = Double.parseDouble(br.readLine());
			
			dist[0] = 0;
			double ans = 0;
			
			for (int i = 0; i < n; i++) {
				double min = INF;
				int idx = -1;
				// 방문하지 않았으면서 가장 작은 값 가져와
				for (int j = 0; j < n; j++) {
					if (!visited[j] && dist[j] < min) {
						min = dist[j];
						idx = j;
					}
				}// 해당 반복문 종료 시, idx는 가장 작은 값 가지고 있다.(방문 x)
				
				
				visited[idx] = true;
				ans += dist[idx];
				// 방문하지 않았고 갱신할 수 있으면 갱신(idx)
				for (int j = 0; j < n; j++) {
					double dist_x = Math.pow((points[idx].x-points[j].x),2);
					double dist_y = Math.pow((points[idx].y-points[j].y),2);
					double len = dist_x+dist_y;
					if (!visited[j] && dist[j] > len) {
						dist[j] = len;
					}
				}
			}
			System.out.printf("#%d %.0f",test ,ans*E);
			System.out.println();
		}
	}
}
