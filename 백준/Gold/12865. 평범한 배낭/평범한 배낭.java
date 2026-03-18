import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N];
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 선언 및 초기화
        int[] dp = new int[K + 1];
//        System.out.println(Arrays.toString(weights));
//        System.out.println(Arrays.toString(values));
        // DP 테이블을 채우는 과정
        for (int i = 0; i < N; i++) {
            int weight = weights[i];
            int value = values[i];
            // 뒤에서부터 탐색하여 이전 상태를 바탕으로 현재 상태를 계산
            for (int j = K; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
//                System.out.println(Arrays.toString(dp) + ", "+j);
            }
        }
        System.out.println(dp[K]);
    }
}