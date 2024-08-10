import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int kA = Integer.parseInt(st.nextToken());

			int[] A = new int[kA];
			for (int number = 0; number < kA; number++)
				A[number] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int kB = Integer.parseInt(st.nextToken());

			int[] B = new int[kB];
			for (int number = 0; number < kB; number++)
				B[number] = Integer.parseInt(st.nextToken());

			int[] countA = new int[5];
			int[] countB = new int[5];

			for (int AA = 0; AA < kA; AA++)
				countA[A[AA]]++;

			for (int BB = 0; BB < kB; BB++)
				countB[B[BB]]++;

			boolean switches = true;
			for (int j = 4; j >= 0; j--) {
				if (countA[j] == countB[j])
					continue;
				else if (countA[j] > countB[j]) {
					switches = false;
					System.out.println("A");
					break;
				} else if (countA[j] < countB[j]) {
					switches = false;
					System.out.println("B");
					break;
				}
			}
			if (switches) {
				System.out.println("D");
			}
		}
	}
}
