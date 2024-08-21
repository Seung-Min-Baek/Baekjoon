import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {
	static LinkedList<Integer> password;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int test = 1; test <= 10; test++) {

			String[] line = br.readLine().split(" ");
			// 입력 받아 char로
			int n = Integer.parseInt(line[0]);
			char[] passwordChar = line[1].toCharArray();

			// char를 int로
			password = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				password.add(passwordChar[i] - '0');
			}

			int find = 0;
			int cnt = 0;
			// 같은 것이 있는지 확인
			while (cnt < n - 1) {
				for (find = 0; find < password.size()-1; find++) {
					// find와 find+1이 같으면 find index 두번 제거(하나 제거 되면 뒤에 것이 앞으로 오므로)
					if (password.get(find) == password.get(find + 1)) {
						password.remove(find);
						password.remove(find);
					
						break;
					}
				}
				cnt++;
			}
			System.out.print("#" + test+ " ");
			for (int i = 0; i < password.size(); i++) {
				System.out.print(password.get(i));
			}
			System.out.println();
		}
	}

}
