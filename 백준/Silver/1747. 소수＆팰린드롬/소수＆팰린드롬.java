import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 소수 체를 위한 배열을 1003002로 설정 (팰린드롬 소수가 커질 가능성에 대비)
        int[] map = new int[1003002];

        // 소수를 미리 배열에 기록
        for (int i = 2; i < map.length; i++) {
            map[i] = i;
        }

        // 에라토스테네스의 체로 소수를 걸러냄
        for (int i = 2; i <= Math.sqrt(map.length); i++) {
            if (map[i] != 0) { // i가 소수인 경우
                for (int j = i + i; j < map.length; j += i) {
                    map[j] = 0; // i의 배수는 소수가 아님
                }
            }
        }

        // 팰린드롬 소수를 찾는 루프
        boolean pelindrom = false;
        for (int i = n; i < map.length; i++) { // n 이상에서만 탐색
            if (map[i] != 0) { // 소수인 경우만 확인
                String num = Integer.toString(i);
                char[] chararr = num.toCharArray();
                pelindrom = true; // 초기값을 true로 설정

                // 팰린드롬인지 확인
                for (int j = 0; j < chararr.length / 2; j++) {
                    if (chararr[j] != chararr[chararr.length - 1 - j]) {
                        pelindrom = false;
                        break; // 팰린드롬이 아닌 경우 즉시 종료
                    }
                }

                // 팰린드롬인 소수를 찾으면 출력하고 종료
                if (pelindrom) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
