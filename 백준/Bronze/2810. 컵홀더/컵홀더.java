
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int p = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split("");
		
		int Lcount = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("L")) {
				Lcount++;
			}
		}
		int holder = str.length - Lcount/2+1;
		
		int res = 0;
		
		if (p<holder)
			 res = p;
		 else
			 res = holder;
		 System.out.println(res);
	}
}
