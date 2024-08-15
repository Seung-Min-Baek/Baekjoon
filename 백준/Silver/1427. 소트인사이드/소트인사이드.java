import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] str = sc.next().split("");
		
		int[] arr = new int[str.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			int Max = i;
			for (int j = i+1; j < arr.length; j++) {
				// 최댓값 찾기
				if (arr[Max] < arr[j]) {
					Max = j;
				}
				if (arr[Max] > arr[i]) {
					int temp = arr[Max];
					arr[Max] = arr[i];
					arr[i] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
