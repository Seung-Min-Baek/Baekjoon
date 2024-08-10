
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] rest = new int[10];
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			
			rest[i] = n%42;
		}
		int count = 0;
		for (int i = 0; i < rest.length; i++) {
			boolean switches = true;
			for (int j = i+1; j < rest.length; j++) {
				if (rest[i]==rest[j]) {
					switches = false;
					break;
				}
			}
			if (switches == true) {
				count++;
			}
		}
		System.out.println(count);
	}
}
