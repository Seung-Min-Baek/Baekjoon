import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[] sorted;	// merge 함수에서 배열 합치면서 정렬된 원소 담을 임시 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 원소 개수
		int n = Integer.parseInt(br.readLine());
		// 원소 입력받을 배열 선언
		int[] arr = new int[n];
		// 배열에 값 입력받기
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 위에서 static으로 선언한 sorted 배열 생성
		sorted = new int[arr.length];
		// 병합 정렬 실행
		mergeSort(arr, 0, n - 1);
		
		// 출력
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	static void mergeSort(int[] arr, int left, int right) {
		// 부분리스트의 원소가 1개일 경우 더이상 쪼갤 수 없으므로 리턴
		if (left == right)
			return;

		int mid = (left + right) / 2;

		mergeSort(arr, left, mid);		// 왼쪽 부분리스트
		mergeSort(arr, mid + 1, right);	// 오른쪽 부분리스트

		merge(arr, left, mid, right);	// 병합작업

	}

	static void merge(int[] arr, int left, int mid, int right) {

		int l = left;		// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트 시작점
		int idx = left;		// 채워넣을 배열의 인덱스


		while (l <= mid && r <= right) {
			// 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같은 경우
			// 왼쪽의 ㅣ번째 원소를 새 배열에 넣고 ㅣ과 idx를 1 증가 시킴
			if (arr[l] <= arr[r])
				sorted[idx++] = arr[l++];

			// 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같은 경우
			// 오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가 시킴
			else
				sorted[idx++] = arr[r++];
		}

		// 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 때(오른쪽 부분리스트 원소가 남아있을 때)
		// 오른쪽 부분리스트에 남아있는 원소들 넣어주기
		if (l > mid) {
			while (r <= right)
				sorted[idx++] = arr[r++];
		} 
		// 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 때(왼쪽 부분리스트 원소가 남아있을 때)
		// 왼쪽 부분리스트에 남아있는 원소들 채워주기
		else {
			while (l <= mid)
				sorted[idx++] = arr[l++];
		}

		// 정렬된 새 배열을 기존의 배열에 복사하여 옮겨줌
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}

}