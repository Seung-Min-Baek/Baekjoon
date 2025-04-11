import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static String[][] box;
    static int count;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        box = new String[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++){
            String[] line = br.readLine().split("");
            for(int j=0; j<m; j++){
                box[i][j] = line[j];
            }
        }// 입력 끝

        for (int i = 0; i<n ; i++){
            for (int j = 0; j <m ; j++){
                if(box[i][j].equals("-") && !visited[i][j]){
                    countFloor("-",i,j);
                    count++;
                }
            }
        }// 가로로 "-" 세기

        for (int i = 0; i<m ; i++){
            for (int j = 0; j <n ; j++){
                if(box[j][i].equals("|") && !visited[j][i]){
                    countFloor("|",j,i);
                    count++;
                }
            }
        }// 세로로 "|" 세기

        System.out.println(count);
    }

    static void countFloor(String shape,int i, int j){
        if(shape.equals("-")){
            if(j == m)
                return; // 범위 밖이면 return
            if(!box[i][j].equals("-")){
                return; // 다른 모양 만나면 return
            }
        }else if(shape.equals("|")){
            if(i == n)
                return; // 범위 밖이면 return
            if(!box[i][j].equals("|")){
                return; // 다른 모양 만나면 return
            }
        } // 기저 조건

        if(box[i][j].equals(shape) && !visited[i][j]){
            visited[i][j] = true;
        } // 모양이 같거나 아직 방문 안했다면, 방문체크
        
        if(shape.equals("-")) {
            countFloor(shape, i, j + 1);
        }else if(shape.equals("|")){
            countFloor(shape, i+1, j);
        } // 모양에 맞게 다음 행 or 열로 이동.
    }
}
