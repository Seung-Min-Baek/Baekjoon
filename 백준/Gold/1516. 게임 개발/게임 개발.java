import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] map = new ArrayList[n + 1];
        int[] weight = new int[n + 1];
        int[] degree = new int[n + 1];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            int cT = st.countTokens();
            for (int j = 1; j < cT; j++) {
                int building = Integer.parseInt(st.nextToken());
                map[building].add(i);
                degree[i]++;
            }
        }
        int[] res = new int[n+1];
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 1; i < n+1; i++) {
        	res[i] = weight[i];
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int p = q.poll();
            for (int next : map[p]) {
                degree[next]--;
                res[next] = Math.max(res[next], res[p] + weight[next]);
                if (degree[next] == 0) {
                    q.add(next);
                    
                }
            }
        }
        for (int i = 1; i < res.length; i++) {
        	System.out.println(res[i]);
		}
    }
}