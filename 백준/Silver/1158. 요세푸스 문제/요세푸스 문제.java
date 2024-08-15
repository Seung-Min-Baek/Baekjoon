import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		Queue<Integer> bin = new LinkedList<Integer>();
		// 큐에 모든 수 넣기
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		while(!q.isEmpty()) {
			// k-1 번동안 제일 앞의 사람 뺴서 맨 뒤에 넣기
			for (int i = 0; i < k-1; i++) {
				int person = q.poll();
				q.add(person);
			}
			// k 번째 사람 뺴서 bin 큐에 넣기
			int trash = q.poll();
			bin.add(trash);
		}
		System.out.print("<");
		for (int i = 0; i < n-1; i++) {
			System.out.print(bin.poll() + ", ");
			
		}
		System.out.print(bin.poll());
		System.out.print(">");
		
	}
}
