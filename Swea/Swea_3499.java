import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			Queue<String> queue1 = new LinkedList<String>();		
			Queue<String> queue2 = new LinkedList<String>();

			int m = Integer.parseInt(br.readLine());

			String[] str = new String[m];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < str.length; i++) {
				str[i] = st.nextToken();
			}
			
			int len = 0;
			
			if (str.length %2 == 0) 
				len = str.length/2;
			else
				len = str.length/2+1;
			
			for (int i = 0; i < len; i++) {
				queue1.add(str[i]);
			}
			for (int i = len; i < str.length; i++) {
				queue2.add(str[i]);
			}
			
			System.out.printf("#%d ", test);
			for (int i = 0; i < len; i++) {
				System.out.print(queue1.poll()+ " ");
				if (queue1.isEmpty()&&queue2.isEmpty()) {
					break;
				}
				System.out.print(queue2.poll() + " ");
			}System.out.println();
			

		}

	}
}
