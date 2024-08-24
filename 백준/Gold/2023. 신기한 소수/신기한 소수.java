import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] firstNum = { 2, 3, 5, 7 };
	static int[] restNum = { 1, 3, 5, 7, 9 };
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[5];
		// 소수 인것 : 2 3 5 7
		// 앞에 한자리는 무조건 이 4개로 시작
		// 그 다음 자리부터 홀수인 1 3 5 7 9붙혀서 검사 ( 짝수는 소수가 아님)
		for (int i = 0; i < firstNum.length; i++) {
			dfs(firstNum[i], 1);
		}

	}

	static void dfs(int x, int cnt) {
		if (cnt == n) {
			System.out.println(x);
			
			return;
		}
		for (int i = 0; i < restNum.length; i++) {
			int num = x * 10 + restNum[i];
//			num이 소수이면 다음 자리 검사
			if (isPrime(num)) {
				dfs(num, cnt+1);
			}
		}
	}

	// 소수인지 검사
	static boolean isPrime(int num) {
		for (int i = 2; i < num/2; i++) {
			if (num % i ==0) {
				return false;
			}
		}
		return true;
	}
}
