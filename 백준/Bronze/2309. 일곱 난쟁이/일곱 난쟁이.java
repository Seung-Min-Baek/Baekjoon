import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[9];
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		int height = sum-100;
		boolean found = false;
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]+arr[j] == height) {
					arr[i] = arr[j] = 0;
					Arrays.sort(arr);
					found = true;
					break;
					
			}
		}
		if(found) break;
		}
		for (int k = 2; k < arr.length; k++) {
			System.out.println(arr[k]);
		}
	}
}
