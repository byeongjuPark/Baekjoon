import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] dp = new int[30][30];
		
		for(int i = 0; i < 30; i++) {
			dp[i][i] = dp[i][0] = 1;
		}
		
		for(int i = 2; i < 30; i++) {
			for(int j = 1; j < 30; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(dp[b][a]);
		}

	}

}
