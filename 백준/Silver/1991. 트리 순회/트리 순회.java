import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] visited;
	static int[][] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		visited = new boolean[n + 1];
		tree = new int[n+1][2];

		
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = st.nextToken().charAt(0) - 64;
			int b = st.nextToken().charAt(0) - 64;
			int c = st.nextToken().charAt(0) - 64;
			
			if(b != -18) tree[a][0] = b;
			if(c != -18) tree[a][1] = c;
		} // 입력 끝
		
		Joongwhi(1);
		System.out.println();
		Jeonwhi(1);
		System.out.println();
		whowhi(1);
	}

	private static void whowhi(int i) {
		if (i > n) {
			return;
		}
		if (tree[i][0] != 0) whowhi(tree[i][0]);
		if (tree[i][1] != 0) whowhi(tree[i][1]);		
		char after = (char)(i+64);
		System.out.print(after);
	}

	private static void Jeonwhi(int i) {
		if (i > n) {
			return;
		}
		if (tree[i][0] != 0) Jeonwhi(tree[i][0]);
		char after = (char)(i+64);
		System.out.print(after);
		if (tree[i][1] != 0) Jeonwhi(tree[i][1]);		
	}

	private static void Joongwhi(int i) {
		if (i > n) {
			return;
		}
		char after = (char)(i+64);
		System.out.print(after);
		if (tree[i][0] != 0) Joongwhi(tree[i][0]);
		if (tree[i][1] != 0) Joongwhi(tree[i][1]);
		
	}
}
