import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long[] sumaArr = new long[n];
		st = new StringTokenizer(br.readLine());
		
		sumaArr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			sumaArr[i] = sumaArr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		long[] countbox = new long[m];
		long count = 0;
//		System.out.println(Arrays.toString(sumaArr));
		for (int i = 0; i < sumaArr.length; i++) {
			int res = (int) (sumaArr[i] %m);
			
			if(res == 0) {
				count++;
			}
			countbox[res]++;
		}
		
		for (int i = 0; i < countbox.length; i++) {
			if (countbox[i]>1) {
				count = count + (countbox[i] * (countbox[i]-1)/2);
			}
		}
		System.out.println(count);
		
	}
}
