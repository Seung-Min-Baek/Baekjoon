import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();
		boolean switches = false;

		String line = br.readLine();

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '<') {
				switches = true;
				while (!stack.isEmpty()) {
					System.out.print(stack.pop());
				}
				System.out.print(line.charAt(i));
			} else if (line.charAt(i) == '>') {
				switches = false;
				System.out.print(line.charAt(i));
			} else if (switches) {
				System.out.print(line.charAt(i));
			} else if (!switches) {
				if (line.charAt(i) == ' ') {
					while (!stack.isEmpty())
						System.out.print(stack.pop());
					System.out.print(line.charAt(i));
				} else
					stack.add(line.charAt(i));
			}

		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}

	}
}
