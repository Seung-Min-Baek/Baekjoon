import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int start = 1;
		int plus = 1;
		while(start<n) {
			start += 6*plus;
			plus++;
		}
		System.out.println(plus);
	}
}
