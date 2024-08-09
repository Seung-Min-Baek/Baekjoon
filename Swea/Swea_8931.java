import java.util.Scanner;
import java.util.Stack;

public class Swea_8931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test = 0; test < T; test++) {
			int K = sc.nextInt();
			Stack<Integer> stackInt = new Stack<>();
			
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				
				if (num == 0) {
					stackInt.pop();
				}else
					stackInt.push(num);
			}
			int sum = 0;
			while(! stackInt.isEmpty()) {
				sum += stackInt.pop();
			}
			
			System.out.printf("#%d %d\n",test+1,sum);
		}
	}
}
