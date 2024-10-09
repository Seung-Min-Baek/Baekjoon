import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m;
	static long[] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // n개의 정수
		m = Integer.parseInt(st.nextToken()); // a,b m개의 짝
		
		// 배열의 크기 구하기
		int mapHeight = 0; // tree의 높이
		int length = n;
		while(length>0) {
			length= length/2;
			mapHeight++;
		}
		int mapSize = (int) Math.pow(2,mapHeight+1);
		
		map = new long[mapSize+1]; // map 배열 초기화
		Arrays.fill(map,1000000000);
		int index = mapSize/2-1; // 시작보다 하나 앞의 인덱스
		
		for (int i = index+1; i <= index + n ; i++) {
			map[i] = Long.parseLong(br.readLine());
		}
		
		setMap(mapSize-1); // tree 채우기
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(findMinValue(a+index, b+ index));
		}
	}

	private static long findMinValue(int startNode, int endNode) {
		long minvalue = 1000000000;
		
		while(startNode<=endNode) {
			if (startNode %2 ==1) {
				minvalue = Math.min(minvalue, map[startNode]);
				startNode++;
			}
			if (endNode %2 == 0) {
				minvalue = Math.min(minvalue, map[endNode]);
				endNode--;
			}
			startNode/=2;
			endNode/=2;
		}
		return minvalue;
	}

	private static void setMap(int i) {
		while(i>1) {
			if(i % 2 == 1) {
				map[i/2] = map[i];
			}else if ( i%2 ==0) {
				map[i/2] = Math.min(map[i/2], map[i]);
			}
			i--;
		}
	}
}
