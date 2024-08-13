
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {

			// 원본 암호문의 길이 N
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				// 원본 암호문 저장
				list.add(Integer.parseInt(st.nextToken()));
			}
			// 명령어의 개수
			int lan_num = Integer.parseInt(br.readLine());
			// 명령어
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < lan_num; i++) {
				// 구분자 "|"
				String Identifier = st.nextToken();
				// list에 넣을 index값
				int index = Integer.parseInt(st.nextToken());

				// 뒤에 입력받을 값 개수
				int count = Integer.parseInt(st.nextToken());
				int[] arr = new int[count];
				for (int j = 0; j < arr.length; j++)
					arr[j] = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < arr.length; j++) {
					list.add(index, arr[j]);
					index++;
				}

			}
			System.out.print("#" + test + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}

	}
}
