import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> first_Half = new ArrayList<>();
		ArrayList<Integer> second_Half = new ArrayList<>();
		
		// 1차전
		for (int i = 1; i <= n; i++) {
			// 등수 입력받기
			int rank = Integer.parseInt(br.readLine());
			
			// 리스트에 해당 등수에 선수 추가
			first_Half.add(rank-1, i);
			
		}
		
		// 2차전
		for (int i = m-1; i >= 0; i--) {
			// m번쨰 부터 선수 저장
			int player = first_Half.get(i);
			// 등수 입력
			int rank = Integer.parseInt(br.readLine());
			// 리스트에 해당 등수에 선수 추가
			second_Half.add(rank-1, player);
		}
		
		// 출력
		for (int i = 0; i < 3; i++) {
			System.out.println(second_Half.get(i));
		}
	}
}
