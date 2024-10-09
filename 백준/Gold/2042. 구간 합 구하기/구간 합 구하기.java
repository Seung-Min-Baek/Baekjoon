import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 수의 개수
		int m = Integer.parseInt(st.nextToken()); // 수의 변경이 일어나는 횟수
		int k = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수

		// 배열 크기 정하기
		int treeHeight = 0; // 트리의 높이 구하기
		int length = n;

		while (length > 0) {
			length = length / 2; // 수의 개수/2 하면서 ex) 5/2 =2 2/2=1 1/2=0
			treeHeight++; // 트리의 높이++ ex) 1 2 3
		}
		int treeSize = (int) Math.pow(2, treeHeight + 1); // 2^(3+1) 트리의 높이+1만큼 2의 제곱을 해주어서 배열의 크기 만들기

		// 데이터 입력받기 ( index 7+1 ~ 7+5까지 입력받기 )
		int halfEnd = treeSize / 2 - 1; // 입력 받기 이전 칸 저장 7
		tree = new long[treeSize+1];
		
		for (int i = halfEnd + 1; i <= halfEnd + n; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}

		// 배열 채우기
		setTree(treeSize - 1);

		// 요소 바꾸기 & 구간 합하기
		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken()); // 1이면 요소 바꾸기 / 2이면 구간합
			long startNode = Integer.parseInt(st.nextToken()); // 시작 노드
			long endNode = Long.parseLong(st.nextToken()); // 1일때 바꿀 숫자 , 2일때 끝노드

			// 요소 바꾸기
			if (a == 1) {
				change(halfEnd + (int)startNode, endNode);
				// 구간 합하기
			} else if (a == 2) {
				startNode = halfEnd + startNode;
				endNode = halfEnd + endNode;
				System.out.println(sum((int)startNode,(int) endNode));
			} else {
				return;
			}
		}
	}

	// 구간합하기
	private static long sum(int startNode, int endNode) {
		long sumValue = 0;

		while (startNode <= endNode) {
			if (startNode % 2 == 1) {
				sumValue += tree[startNode];
				startNode++;
			}
			if (endNode % 2 == 0) {
				sumValue += tree[endNode];
				endNode--;
			}
			startNode/=2;
			endNode/=2;
		}
		return sumValue;
	}

	// 요소 바꾸기
	private static void change(int Node, long num) {
		long plusNum = num - tree[Node];
		while (Node > 0) {
			tree[Node] = tree[Node] + plusNum;
			Node /= 2;
		}
	}

	private static void setTree(int i) {
		while (i > 1) {
			tree[i / 2] += tree[i]; // 부모 노드에 자식 노드 두개의 합 더하기
			i--;
		}
	}
}
