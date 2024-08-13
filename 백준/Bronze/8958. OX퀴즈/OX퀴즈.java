import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			char[] score = sc.next().toCharArray();
			
			int total = 0;
			int sum = 0;
			
			for (int i = 0; i < score.length; i++) {
				if(score[i] == 'O') {
					sum += 1;
					total += sum;
				}

				else {
						sum = 0;
				}
			}
			System.out.println(total);
		}
	}

}
