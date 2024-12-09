import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static int[] p;
	static boolean[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		p = new int[m];
		arr = new boolean[n+1];
		
		backtracking(1,0);
	}

	private static void backtracking(int x, int sit) {
		
		if(sit == m) {
			for (int i = 0; i < p.length; i++) {
				System.out.print(p[i] + " ");
			}
			System.out.println();
			return;
		}
		
		
		// false이면 출력
		for (int i = 1; i <= n; i++) {
			if (!arr[i]) 
				p[sit] = i;
			else 
				continue;
			
			arr[i] = true;
			backtracking(i+1, sit+1);
			arr[i] = false;
		}
	}
}
