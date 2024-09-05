import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] sik = br.readLine().split("-");
		int ans = 0;
		for (int i = 0; i < sik.length; i++) {
			int sum = mySum(sik[i]);
			if (i==0) {
				ans += sum;
			}
			else {
				ans-= sum;
			}
		}
		System.out.println(ans);
		
	}

	private static int mySum(String str) {
		
		String[] hap = str.split("\\+");
		int sum=0;
		for (int i = 0; i < hap.length; i++) {
			sum += Integer.parseInt(hap[i]);
		}
		
		return sum;
	}
}
