import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		int[][] bat = new int[6][2];

		// 1 , 2에 들어온 변의 길이중 가장 큰것 : M
		int Max = 0;
		int Max_index = -1;
		// 3 , 4에 들어온 변의 길이중 가장 큰것 : m
		int max = 0;
		int max_index = -1;
		for (int i = 0; i < bat.length; i++) {
			String[] line = br.readLine().split(" ");
			bat[i][0] = Integer.parseInt(line[0]);
			bat[i][1] = Integer.parseInt(line[1]);

			if (bat[i][0] == 1 || bat[i][0] == 2) {
				if (bat[i][1] > Max) {
					Max = bat[i][1];
					Max_index = i;
				}
			}
			if (bat[i][0] == 3 || bat[i][0] == 4) {
				if (bat[i][1] > max) {
					max = bat[i][1];
					max_index = i;
				}
			}
		}
		int total_Area = Max * max;
		// 제외할 넓이 구하기
		// 최대 가로, 세로 길이 양 옆 선분을 뺴면 제외할 넓이를 구할수 있는 선분.

		int garo = 0;
		int sero = 0;
		// 최대 가로 길이에서 양 옆 세로 구하기
		if (Max_index + 1 == 6) {
			garo = Math.abs(bat[0][1] - bat[Max_index - 1][1]);
		} else if (Max_index - 1 == -1) {
			garo = Math.abs(bat[5][1] - bat[Max_index + 1][1]);
		}else {
			garo = Math.abs(bat[Max_index-1][1] - bat[Max_index +1][1]);
		}
		// 최대 가로 길이에서 양 옆 세로 구하기
		if (max_index + 1 == 6) {
			sero = Math.abs(bat[0][1] - bat[max_index - 1][1]);
		} else if (max_index - 1 == -1) {
			sero = Math.abs(bat[5][1] - bat[max_index + 1][1]);
		}else {
			sero = Math.abs(bat[max_index-1][1] - bat[max_index +1][1]);
		}
		int minus_Area = garo * sero;
		int res_Area = total_Area - minus_Area;

		System.out.println(res_Area * k);
	}
}
