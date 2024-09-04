import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] timetable = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			timetable[i][0] = Integer.parseInt(st.nextToken());
			timetable[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(timetable, new Comparator<int[]>() {

			@Override
			public int compare(int[] S, int[] E) {
				if (S[1] == E[1]) {
					return S[0] - E[0];
				}
				return S[1]-E[1];
			}
		});
		int cnt = 0;
		int end = -1;
		for (int q = 0; q < n; q++) {
			if (timetable[q][0] >= end) {
				end = timetable[q][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
