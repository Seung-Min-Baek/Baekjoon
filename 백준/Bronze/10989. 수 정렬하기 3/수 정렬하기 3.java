import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 원소 개수 입력 받기
		int n = Integer.parseInt(br.readLine());
		// 원소 저장할 배열 생성
		int[] arr = new int[n];
		// 최댓값 저장할 변수 선언(최대 자릿수 구하기 위함)
		int max = Integer.MIN_VALUE;
		// 배열 원소 입력 받기
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			// 입력받으면서 최댓값도 같이 저장
			max = Math.max(max, arr[i]);
		}
		
		// 기수 정렬 수행
		radixSort(arr, 5);
		
		// 정렬된 결과 출력
		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static void radixSort(int[] arr, int k) {
		int[] output = new int[arr.length];
		int jarisu = 1;
		int count = 0;
		
		while(count != k) {
			int[] bucket = new int[10];
			for (int i = 0; i < arr.length; i++) {
				bucket[(arr[i]/jarisu)%10]++;
			}
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i-1];
			}
			for (int i = arr.length - 1; i >= 0; i--) {
				output[bucket[(arr[i]/jarisu % 10)] - 1] = arr[i];
				bucket[(arr[i]/jarisu) % 10]--;
			}
			for (int i = 0; i < arr.length; i++) {
				arr[i] = output[i];
			}
			jarisu = jarisu * 10;
			count++;
		}
	}
}
