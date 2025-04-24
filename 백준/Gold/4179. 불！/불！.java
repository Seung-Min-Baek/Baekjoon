import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int X,Y;

    Pair(int X,int Y){
        this.X = X;
        this.Y = Y;
    }
}

public class Main {

    static int r,c;
    static String[][] map;
    static int[][] jihoon, fire;
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new String[r][c];
        jihoon = new int[r][c];
        fire = new int[r][c];

        Queue<Pair> jihoonQ = new LinkedList<>();
        Queue<Pair> fireQ = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            String[] string = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = string[j];
                if (map[i][j].equals("J")) {
                    jihoonQ.add(new Pair(i, j));
                    jihoon[i][j] = 0;
                } else if (map[i][j].equals("F")) {
                    fireQ.add(new Pair(i, j));
                    fire[i][j] = 0;
                } else {
                    jihoon[i][j] = -1;
                    fire[i][j] = -1;
                }
            }
        }

        while(!fireQ.isEmpty()){
            Pair cur = fireQ.poll();
            for (int i=0; i<4;i++){
                int nr = cur.X + dr[i];
                int nc = cur.Y + dc[i];
                if(nr<0 || nr>=r || nc<0 || nc>=c) continue;
                if(fire[nr][nc]>=0 || map[nr][nc].equals("#")) continue;
                fire[nr][nc] = fire[cur.X][cur.Y] + 1;
                fireQ.offer(new Pair(nr,nc));
            }
        }

        while(!jihoonQ.isEmpty()){
            Pair cur = jihoonQ.poll();
            for (int i=0;i<4;i++){
                int nr = cur.X + dr[i];
                int nc = cur.Y + dc[i];
                if(nr<0 || nr>=r || nc<0 || nc>=c) {
                    System.out.println(jihoon[cur.X][cur.Y] +1);
                    return;
                }
                if (jihoon[nr][nc] >= 0 || map[nr][nc].equals("#")) continue;
                if (fire[nr][nc] != -1 && fire[nr][nc] <= jihoon[cur.X][cur.Y]+1) continue;
                jihoon[nr][nc] = jihoon[cur.X][cur.Y] + 1;
                jihoonQ.offer(new Pair(nr,nc));
            }
        }

        System.out.println("IMPOSSIBLE");

    }
}
