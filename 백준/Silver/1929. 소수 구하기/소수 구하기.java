import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		boolean[] arr = new boolean[n + 1];
		// 1은 소수가 아니므로 true
		arr[1] =true; 
		// 2부터 n까지
		for (int i = 2; i <=Math.sqrt(n); i++) {
			// 소수 체크가 안된 것들만 검사
			if (!arr[i]) {
				// m부터 
				for (int j = m; j < n + 1; j++) {
					// 나눠 떨어지는 것들은 
					if (j % i == 0) {
						// 소수가 아니다.
						arr[j] = true;
					}
				}
				// 첫번째 숫자는 소수
				arr[i] = false;
			}

		}
		// false인것들만 출력
		for (int i = m; i < arr.length; i++) {
			if (!arr[i]) {
				System.out.println(i);
			}
		}

	}
}
