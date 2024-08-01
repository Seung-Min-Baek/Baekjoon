import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int k = sc.nextInt();

		int[][] arr = new int[2][6];

		int room = 0;
		
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			arr[s][y-1]++;

		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % k == 0) {
					room += arr[i][j] / k;
				}else
					room += arr[i][j] / k +1;
			}
		}
		System.out.println(room);
	}
}
