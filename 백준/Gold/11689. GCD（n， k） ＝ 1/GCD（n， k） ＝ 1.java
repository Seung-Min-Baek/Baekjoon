import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long result = n;
		for (int i = 2; i <= Math.sqrt(n); i++) { // 제곱근까지만 업데이트
			if (n % i == 0) {
				result = result - result / i; // 결과값 업데이트
				while (n % i == 0) { 
					n = n / i;
				}
			}
		}
		if (n>1) { // 아직 소인수 구성이 남아 있을 때
			// 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스 
			result = result - result/n;
		}
		System.out.println(result);
	}
}
