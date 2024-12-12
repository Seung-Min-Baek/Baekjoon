import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			
			if (k == 0) {
				
				if (queue.isEmpty()) {
					System.out.println(0);
				}else {
					int res = queue.poll();
					System.out.println(res);
				}
			}else {
				queue.add(k);
			}
			
		}
	}
}
