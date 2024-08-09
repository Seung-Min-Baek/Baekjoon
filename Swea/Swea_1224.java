import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Swea_1224 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {

			int t = Integer.parseInt(br.readLine());

			String str = br.readLine();

			String result = infixToPostfix(str);

			int res = evalPostfix(result);

			System.out.printf("#%d %d\n", test, res);

		}
	}

	static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('+', 1);
		map.put('*', 2);
		map.put('(', 0);
	}

	// 후위표기식 계산
	static String infixToPostfix(String infix) {

		String postfix = "";
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			if ('0' <= c && c <= '9') {
				postfix += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				while (popItem != '(') {
					postfix += popItem;
					popItem = stack.pop();
				}
			} else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek())>=map.get(c)) {
					char popItem = stack.pop();
					postfix += popItem;
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}

		return postfix;
	}

	static int evalPostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if ('0' <= c && c <= '9') {
				stack.push(c - '0');
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				int res = 0;

				if (c == '+') {
					res = num1 + num2;
				} else if(c == '*') {
					res = num1 * num2;
				}

				stack.push(res);
			}

		}
		return stack.pop();
	}
}
