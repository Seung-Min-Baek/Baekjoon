import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i < arr.length; i++) {
			int insert_point = i;
			int insert_value = arr[i];
			for (int j = i-1; j >= 0; j--) {
				// 현재 정렬 대상 값을 작은 것(j) 바로 오른쪽에 위치
				if (arr[j]<arr[i]) {
					insert_point= j+1;
					break;
				}
				// j가 0까지 오면 0에 insert 할것임.
				if (j == 0) {
					insert_point=0;
				}
			}
			// 삽입 위치에서 i까지 한 칸씩 뒤로 밀기
			for (int j = i; j > insert_point; j--) {
				arr[j] = arr[j-1];
			}
			arr[insert_point] = insert_value;
		}
		int[] sum = new int[n];
		sum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		int s = 0;
		for (int i = 0; i < sum.length; i++) {
			s += sum[i];
		}
		System.out.println(s);
	}
}
