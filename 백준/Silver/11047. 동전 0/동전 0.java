import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(br.readLine());
			
		int cnt = 0;
		
		for (int i = arr.length-1; i >= 0; i--) {
			if (arr[i]>m) {
				continue;
			}
			cnt += m/arr[i];
			int rest = m % arr[i];
			m = rest;
		}
		System.out.println(cnt);
	}
}
