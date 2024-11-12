import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int test = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= test; t++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int dx = Math.abs(x2-x1);
			int dy = Math.abs(y2-y1);
			
			if (dx<dy) {	// dy가 dx보다 크면 값 바꾸기( dx값이 항상 크도록 유지)
				int temp = dx;
				dx = dy;
				dy = temp;
			}
			
			int res = (dx/2)*4 + (dx%2);
			
			if (dy%2==1) {
				if (dx%2==1) 
					res++;
				else
					res--;
			}
			System.out.println("#"+t + " "+res);
		}
	}
}
