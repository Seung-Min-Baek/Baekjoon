import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	static int num;
	static int[] arr , out_arr;
	static Stack<Integer> stack;
	static LinkedList<String> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		num = 1;

		// 입력값 받기
		arr = new int[n];
		out_arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		stack = new Stack<>();
		list = new LinkedList<>();
		
		for (int i = 0; i < arr.length; i++) {
			while (num <= arr[i]) {
				stack.push(num);
				list.add("+");
				num++;
			}
			if (num > arr[i]) {
				int pop = stack.pop();
				out_arr[i] = pop;
				list.add("-");
			}
		}
		boolean booly = true;
		for (int i = 0; i < n; i++) {
			if (!(arr[i] == out_arr[i]))
				booly = false;
		}
		if (booly) {
			for (String data : list) {
				System.out.println(data);
			}
		}else {
			System.out.println("NO");
		}
	}
}