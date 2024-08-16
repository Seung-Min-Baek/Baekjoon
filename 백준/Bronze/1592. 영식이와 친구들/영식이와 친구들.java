import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] sit = new int[n+1];
		
		int idx = 1, cnt=0;
		sit[1] = 1;
		
		while(sit[idx]<m) {
			cnt++;
			if(sit[idx]%2 != 0) {
				idx = (idx+l)%n == 0 ? n : (idx+l)%n;
				++sit[idx];
			} else {
				idx = (idx+(n-l))%n == 0 ? n : (idx+(n-l))%n;
				++sit[idx];
			}
		}
		
		System.out.println(cnt);
		
	}

}
