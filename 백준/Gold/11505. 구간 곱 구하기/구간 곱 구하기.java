import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static int MOD = 1000000007;
    static long[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int treeHeight = 0;
        int length = n;
        
        // 트리의 높이 계산
        while(length > 0) {
            length = length / 2;
            treeHeight++;
        }
        
        // 트리의 전체 크기 설정
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize];
        Arrays.fill(tree, 1); // 곱셈이기 때문에 기본 값을 1로 설정
        
        int index = treeSize / 2 - 1;
        
        // 리프 노드에 입력값을 채움
        for (int i = index + 1; i <= index + n; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }
        
        // 트리 초기화
        setTree(treeSize - 1);
        
        // 쿼리 처리
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            if (a == 1) {
                // b번째 수를 c로 변경
                change(index + b, c);
            } else if(a == 2){
                // b부터 c까지의 구간 곱을 출력
                System.out.println(multiple(index + b, (int) (index + c)));
            } else {
                return;
            }
        }
    }
    
    // 구간 곱을 구하는 함수
    private static long multiple(int startNode, int endNode) {
        long mul = 1;
        
        while(startNode <= endNode) {
            // startNode가 홀수이면 해당 노드를 포함시키고 다음 노드로 이동
            if (startNode % 2 == 1) {
                mul = (mul * tree[startNode]) % MOD;
                startNode++;
            }
            // endNode가 짝수이면 해당 노드를 포함시키고 이전 노드로 이동
            if (endNode % 2 == 0) {
                mul = (mul * tree[endNode]) % MOD;
                endNode--;
            }
            startNode /= 2;
            endNode /= 2;
        }
        return mul;
    }
    
    // 특정 노드를 c로 변경하는 함수
    private static void change(int node, long c) {
        tree[node] = c;
        while(node > 1) {
            node /= 2;
            tree[node] = (tree[node * 2] % MOD * tree[node * 2 + 1] % MOD) % MOD;
        }
    }
    
    // 트리 초기화 함수
    private static void setTree(int i) {
        while(i > 1) {
            tree[i / 2] = (tree[i / 2] * tree[i]) % MOD;
            i--;
        }
    }
}
