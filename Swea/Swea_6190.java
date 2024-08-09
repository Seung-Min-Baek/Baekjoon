import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_6190 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] a = new String[n];
		for (int i = 0; i < a.length; i++) 
			a[i] = st.nextToken();
		
		int max = -1;
		
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				// 곱셈 
				int num = Integer.parseInt(a[i]) * Integer.parseInt(a[j]); 
				if (logic(num)) {
					if (max< num) {
						max = num;
					}
				}
				
			}
		}
		System.out.println("#" + test +" "+ max);
		
		}
	}
	static boolean logic(int num) {
		// 곱셈의 자리 비교
		String str= Integer.toString(num);
		for (int k = 0; k < str.length()-1; k++) {
			if (str.charAt(k)-'0' > str.charAt(k+1)-'0') {
				return false;
			}
		}
		return true;
	}
}
