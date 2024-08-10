import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] alphabet = br.readLine().toCharArray();

		int count = 0;
		for (int i = alphabet.length - 1; i >= 0; i--) {
			if (alphabet[i] == '=') {
				if (i >= 2 && alphabet[i - 1] == 'z' && alphabet[i - 2] == 'd') {
					i = i - 2;
				} else if (i >= 1 && (alphabet[i - 1] == 'c' || alphabet[i - 1] == 's' || alphabet[i - 1] == 'z')) {
					i--;
				}
			} else if (alphabet[i] == ('-')) {
				if (i >= 1 && (alphabet[i - 1] == ('c') || alphabet[i - 1] == 'd')) {
					i--;
				}
			} else if (alphabet[i] == 'j') {
				if (i >= 1 && (alphabet[i - 1] == 'l' || alphabet[i - 1] == 'n')) {
					i--;
				}
			}
			count++;

		}
		System.out.println(count);
	}
}
