import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// start
		// 첫구간합
		int window = 0;
		for(int i = 0; i < x; i++) {
			window += arr[i];
		}
		
		int result = window;
		int cnt = 1;
		
		// 슬라이딩
		for(int i = 1; i<=n-x; i++) {
			window -= arr[i-1];
			window += arr[i+x-1];
			
			if(window > result) {
				result = window;
				cnt = 1;
			} else if(window == result) {
				cnt++;
			}
		}
		
		
		if(result == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(result);
			System.out.println(cnt);
		}
	}
}
