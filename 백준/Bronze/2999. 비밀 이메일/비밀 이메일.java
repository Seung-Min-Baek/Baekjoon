
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] vocab = br.readLine().toCharArray();
		
		int n = vocab.length;
		
		int row = 0;
		int col = 0;
		// 약수 구하기
		for (int i = 1; i <= n; i++) {
			int j = n / i;
			if (n % i == 0 && i<=j) {
				row = i;
				col = j;
			}
		}
		
		int index = 0;
		char[][] mail = new char[row][col];
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				mail[j][i] = vocab[index];
				index++;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(mail[i][j]);
			}
		}
	}
}
