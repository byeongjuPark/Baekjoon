import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		
		while(true) {
			if(K == 0) break;
			for(int i = N-1 ; i >= 0; i--) {
				if(K >= coins[i] ) {
					cnt++;
					K = K - coins[i];
					break;
				}
			}
		}
		System.out.println(cnt);
		
	}
}
