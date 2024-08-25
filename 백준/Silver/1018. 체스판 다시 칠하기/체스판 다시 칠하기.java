import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] pan = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                pan[i][j] = line[j];
            }
        }

        int min = 64; // 최대로 나올 수 있는 값은 64이므로 초기값으로 설정

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int cnt1 = 0; // W로 시작하는 체스판과의 차이
                int cnt2 = 0; // B로 시작하는 체스판과의 차이

                for (int r = i; r < i + 8; r++) {
                    for (int c = j; c < j + 8; c++) {
                        // W로 시작하는 경우와 B로 시작하는 경우를 모두 확인
                        if ((r + c) % 2 == 0) {
                            if (pan[r][c] != 'W') cnt1++;
                            if (pan[r][c] != 'B') cnt2++;
                        } else {
                            if (pan[r][c] != 'B') cnt1++;
                            if (pan[r][c] != 'W') cnt2++;
                        }
                    }
                }

                min = Math.min(min, Math.min(cnt1, cnt2));
            }
        }
        System.out.println(min);
    }
}
