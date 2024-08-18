import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 남학생 : 자신의 배수 상태를 바꿈
		// 여학생 : 자신의 수 스위치를 중심으로 좌우 대칭이면서 가장 많은 스위치를 포함하는 구간 찾음.

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] st = br.readLine().split(" ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);

		int person = Integer.parseInt(br.readLine());

		int[][] switches = new int[person][2];
		for (int i = 0; i < person; i++) {
			String[] str = br.readLine().split(" ");
			switches[i][0] = Integer.parseInt(str[0]);
			switches[i][1] = Integer.parseInt(str[1]);
			// 남학생
			if (switches[i][0] == 1) {
				int cur = switches[i][1]-1;
				while (cur < n) {
					if (arr[cur] == 0) {
						arr[cur] = 1;
					} else if (arr[cur] == 1) {
						arr[cur] = 0;
					}
					cur += switches[i][1];
				}
			// 여학생
			} else if (switches[i][0] == 2) {
				int cur = switches[i][1]-1;
				for (int j = 0; j < arr.length; j++) {
					if (cur-j < 0 || cur+j >arr.length-1) {
						break;
					}
					
					if (arr[cur - j] == arr[cur + j]) {
						if (arr[cur - j] == 0 && arr[cur + j] == 0) {
							arr[cur - j] = 1;
							arr[cur + j] = 1;
						} else if (arr[cur - j] == 1 && arr[cur + j] == 1) {
							arr[cur - j] = 0;
							arr[cur + j] = 0;
						}
						
					}else {
						break;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			if ((i+1)%20 == 0) {
				System.out.println();
			}
		}
	}
}
