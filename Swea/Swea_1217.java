import java.util.Scanner;

public class Swea_1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test = 1; test <= 10; test++) {
			
			int t = sc.nextInt();
			
			int n = sc.nextInt();
			int e = sc.nextInt();
			
			System.out.printf("#%d %d\n",test, com(n,e));
			
			
		}
	}
	
	static int com(int N, int expo) {
		if (expo == 0) {
			return 1;
		}
		
		return N * com(N,expo-1);
	}
}
