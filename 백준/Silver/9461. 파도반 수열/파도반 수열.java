import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		long[] dp = new long[101]; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for(int i = 6; i  < 101; i++) {
			dp[i] = dp[i-5] + dp[i-1];
		}
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
