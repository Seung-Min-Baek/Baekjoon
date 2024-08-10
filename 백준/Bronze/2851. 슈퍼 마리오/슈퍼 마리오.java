import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		int min = 100;
		int res = 0;
		for (int mush = 0; mush < 10; mush++) {
			int room = Integer.parseInt(br.readLine());
			sum += room;
			int minus = Math.abs(100-sum);
			
			if (min>=minus) {
				min = minus;
				res = sum;
			}
		}
		System.out.println(res);
		
		
	}
}
