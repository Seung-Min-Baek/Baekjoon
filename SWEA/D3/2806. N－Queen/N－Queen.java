import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int n;
	static int[] board;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int test = 1; test <= t; test++) {
			n = Integer.parseInt(br.readLine());
			board = new int[n];
			res = 0;
			queen(0);
			System.out.println("#" + test + " " + res);
		}
	}

	static void queen(int r) {
		boolean isPossible;
		if (r == n) {
			res++;
			return;
		}

		for (int c = 0; c < n; c++) {
			isPossible = true;
			for (int i = 0; i < r; i++) { // 직선, 대각선 확인
				if (board[i] == c || board[i] + (r - i) == c || board[i] - (r - i) == c) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				board[r] = c;
				queen(r + 1);
			}
		}

	}
}
