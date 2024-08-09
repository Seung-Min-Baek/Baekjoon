import java.util.Scanner;
import java.util.Stack;

public class Swea_1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		out: for (int test = 1; test <= 10; test++) {

			int n = sc.nextInt();
			String[] A = sc.next().split("");

			Stack<String> text = new Stack<>();
			for (int i = 0; i < A.length; i++) {
				if (A[i].equals(")") || A[i].equals("}") || A[i].equals("]") || A[i].equals(">")) {

					if (text.isEmpty()) {
						System.out.printf("#%d %d\n", test, 0);
						continue out;
					}

					switch (A[i]) {
					case ")":
						if (text.peek().equals("(")) {
							text.pop();
							break;
						} else {
							System.out.printf("#%d %d\n", test, 0);
							continue out;
						}

					case "}":
						if (text.peek().equals("{")) {
							text.pop();
							break;
						} else {
							System.out.printf("#%d %d\n", test, 0);
							continue out;
						}
					case "]":
						if (text.peek().equals("[")) {
							text.pop();
							break;
						} else {
							System.out.printf("#%d %d\n", test, 0);
							continue out;
						}

					case ">":
						if (text.peek().equals("<")) {
							text.pop();
							break;
						} else {
							System.out.printf("#%d %d\n", test, 0);
							continue out;
						}
					}
				} else {
					text.push(A[i]);
//					System.out.println(i);
				}
			}
			if (text.isEmpty()) {
				System.out.printf("#%d %d\n", test, 1);
			} else
				System.out.printf("#%d %d\n", test, 0);

		}
	}
}
