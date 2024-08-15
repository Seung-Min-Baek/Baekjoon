import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] sentence = br.readLine().toCharArray();

		int m = Integer.parseInt(br.readLine());

		Stack<Character> L_stack = new Stack<Character>();
		Stack<Character> R_stack = new Stack<Character>();
		// left에 sentence 모두 넣기
		for (int j = 0; j < sentence.length; j++)
			L_stack.add(sentence[j]);

		for (int i = 0; i < m; i++) {

			String[] line = br.readLine().split(" ");
			char[] words = new char[line.length];
			for (int j = 0; j < line.length; j++) {
				words[j] = line[j].charAt(0);

			}
			char edit = words[0];

			// L : 왼쪽으로 커서 이동
			// 커서 중심으로 왼쪽에 있던 단어 오른쪽으로 이동
			if (edit == 'L') {
				if (L_stack.isEmpty()) {
					continue;
				}
				R_stack.add(L_stack.pop());
				// D : 오른쪽으로 커서 이동
				// 커서 중심으로 오른쪽에 있던 단어 왼쪽으로 이동
			} else if (edit == 'D') {
				if (R_stack.isEmpty()) {
					continue;
				}
				L_stack.add(R_stack.pop());
				// B : 왼쪽에 있는 문자 삭제
			} else if (edit == 'B') {
				if (L_stack.isEmpty()) {
					continue;
				}
				L_stack.pop();
				// P : 왼쪽에 문자 추가
			} else if (edit == 'P') {
				L_stack.add(words[1]);
			}
		}
		while (!L_stack.isEmpty())
			R_stack.add(L_stack.pop());
		while (!R_stack.isEmpty())
			bw.write(R_stack.pop());
		
		bw.flush();
		bw.close();
		
	}
}
