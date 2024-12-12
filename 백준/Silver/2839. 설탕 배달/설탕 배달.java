import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		while(n>=0) {

			if (n % 5 == 0) {
				count += n / 5;
				System.out.println(count);
				break;
			} else {
				n -=3;
				count +=1;
				
			}
		}
		if (n<0) {
			System.out.println(-1);
		}
	}
}
