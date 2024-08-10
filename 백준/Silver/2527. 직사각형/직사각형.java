
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			int[] arrbox = new int[8];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				arrbox[j] = Integer.parseInt(st.nextToken());
			}
			int x1 = arrbox[0];
			int y1 = arrbox[1];
			int p1 = arrbox[2];
			int q1 = arrbox[3];
			int x2 = arrbox[4];
			int y2 = arrbox[5];
			int p2 = arrbox[6];
			int q2 = arrbox[7];
			
				// no
			if (q1 < y2 || p1 < x2 || q2 < y1 || p2 < x1) {
				System.out.println("d");
				// 점
			} else if (((p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2))
					|| ((x1 == p2 && y1 == q2) || (x1 == p2 && y2 == q1))) {
				System.out.println("c");
				// 선
			} else if (p1 == x2 || q1 == y2 || p2 == x1 || y1 == q2) {
				System.out.println("b");
				// 면
			} else {
				System.out.println("a");
			}
		}
	}
}
