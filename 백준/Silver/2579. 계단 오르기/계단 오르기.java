
import java.io.*;

public class Main {

	// 계단은 한 번에 한 계단 또는 두 계단
	// 연속된 세 개의 계단을 모두 밟으면 안됨
	// 마지막 도착 계단은 반드시 밟아야 함.
	private static int[] dp, arr;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = arr[1];
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}

		for (int i = 3; i < N + 1; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
		}

		System.out.println(dp[N]);
	}

}
