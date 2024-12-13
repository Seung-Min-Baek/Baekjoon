import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if (a == 0) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				}else {
					int give = queue.poll();
					System.out.println(give);
				}
			}else {
				while(st.hasMoreTokens()) {
					int gift = Integer.parseInt(st.nextToken());
					queue.add(gift);
				}
			}
//			for (int j = 0; j < a; j++) {
//				
//			}
		}
	}
}
