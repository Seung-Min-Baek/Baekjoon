import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] kyu;
	static int[] in;
	static boolean[] visited;
	static int[] in_num;
	static int kyu_cnt;
	static int in_cnt;
	
	static int kyu_res;
	static int in_res;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
			
			boolean[] card = new boolean[19];
			
			kyu = new int[9];
			for (int i = 0; i < 9; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				card[kyu[i]] = true;
			}
			
			in = new int[9];
			for (int i = 1,index = 0; i < card.length; i++) {
				if (!card[i]) {
					in[index] = i;
					index++;
				}
			}
			kyu_res =0;
			in_res =0;
			visited = new boolean[9];
			in_num = new int[9];
			soonyeul(0);
			
			System.out.println("#"+ test + " " +kyu_res + " " + in_res);
			
		}
	}
	
	static void soonyeul(int x) {
		
		if (x == 9) {
			kyu_cnt = 0;
			in_cnt = 0;
			chocolate(0);
			winner();
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] =true;
				in_num[x] = in[i];
				soonyeul(x+1);
				visited[i] = false;
				
			}
		}
	}
	static void chocolate(int idx) {
		if (idx == 9) {
			return;
		}
		// kyu win! 합을 cnt
		if (kyu[idx]>in_num[idx]) {
			kyu_cnt += kyu[idx] + in_num[idx];
		}
		// in win! 합을 cnt
		if (kyu[idx]<in_num[idx]) {
			in_cnt += kyu[idx] + in_num[idx];
		}
		chocolate(idx+1);
	}
	
	static void winner() {
		if (kyu_cnt>in_cnt) {
			kyu_res++;
		}
		if (kyu_cnt<in_cnt) {
			in_res++;
		}
		
	}
}
