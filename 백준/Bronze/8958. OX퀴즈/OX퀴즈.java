import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < T; test++) {
			char[] quiz = br.readLine().toCharArray();
			
			int count = 0;
			int score = 0;
			for (int i = 0; i < quiz.length; i++) {
				if (quiz[i] == 'O') {
					score++;
					count +=score;
				} else {
					score =0;
				}
			}
			System.out.println(count);
		}
	}
}
