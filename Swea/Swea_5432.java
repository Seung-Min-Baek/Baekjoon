import java.util.Scanner;
import java.util.Stack;

public class Swea_5432 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test = 0; test < T; test++) {
			String[] A = sc.next().split("");
			Stack<String> stck = new Stack<>();
			
			int count = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i].equals(")") || A[i].equals("}") || A[i].equals("]") || A[i].equals(">")) {
					
				}else {
					stck.push(A[i]);
				}
			}
		}
	}
}
