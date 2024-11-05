import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int[] box, out;
    static boolean[] visited;
    static int n,m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        box = new int[n];
        out = new int[n];
        visited = new boolean[n];
        
        for (int i = 0; i < box.length; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(box);
        dfs(0);
        
    }

    private static void dfs(int cnt) {
        if(cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
        }else {
            int before = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                if (before != box[i]) {    // before과 값이 다르면( 중복 방지)
                    
                    visited[i] = true; // 방문체크
                    out[cnt] = box[i]; // out 배열에 수열 수 넣기
                    before = box[i];   // 이전 값에 수열 수 넣기( 중복 방지)
                    
                    dfs(cnt+1);
                    
                    visited[i] = false;// 방문 해제
                }
            }
        }
    }
}