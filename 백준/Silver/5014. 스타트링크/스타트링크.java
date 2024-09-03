import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int f; // 총 층수
    static int s; // 시작 층
    static int g; // 목표 층
    static int u; // 위로 이동할 층수
    static int d; // 아래로 이동할 층수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 현재 층을 체크하기 위한 방문 배열
        boolean[] visited = new boolean[f + 1];
        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[f + 1]; // 층별 거리

        // 시작 층 초기화
        queue.offer(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 목표 층 도달
            if (current == g) {
                System.out.println(dist[current]);
                return;
            }

            // 위로 이동
            int nextUp = current + u;
            if (nextUp <= f && !visited[nextUp]) {
                visited[nextUp] = true;
                queue.offer(nextUp);
                dist[nextUp] = dist[current] + 1;
            }

            // 아래로 이동
            int nextDown = current - d;
            if (nextDown >= 1 && !visited[nextDown]) {
                visited[nextDown] = true;
                queue.offer(nextDown);
                dist[nextDown] = dist[current] + 1;
            }
        }

        // 목표 층에 도달할 수 없는 경우
        System.out.println("use the stairs");
    }
}
