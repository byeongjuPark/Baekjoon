import java.io.*;
import java.util.*;

//X가 3으로 나누어 떨어지면, 3으로 나눈다.
//X가 2로 나누어 떨어지면, 2로 나눈다.
//1을 뺀다.
// 10 9 3 1
class Main {
    static int N;
    static int dp[];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        for(int i = 2; i < N + 1; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        
        System.out.println(dp[N]);
    }
}