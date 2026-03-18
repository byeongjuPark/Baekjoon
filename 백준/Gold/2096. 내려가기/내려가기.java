import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
3
1 2 3
4 5 6
4 9 0
     */
    static int N;
    static int[][] max_dp;
    static int[][] min_dp;
    static int[][] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        max_dp = new int[N][3];
        min_dp = new int[N][3];
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){
                min_dp[i][j] = Integer.MAX_VALUE;
            }
        }
        nums = new int[N][3];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                nums[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0) max_dp[i][j] = min_dp[i][j] = nums[i][j];
            }
        }
        for(int i = 1; i < N; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    max_dp[i][j] = Math.max(nums[i][j] +  max_dp[i-1][j], nums[i][j] + max_dp[i-1][j+1]);
                    min_dp[i][j] = Math.min(nums[i][j] +  min_dp[i-1][j], nums[i][j] + min_dp[i-1][j+1]);
                } else if(j == 1){
                    max_dp[i][j] = Math.max(nums[i][j] +  max_dp[i-1][j-1], nums[i][j] + max_dp[i-1][j]);
                    max_dp[i][j] = Math.max(max_dp[i][j], nums[i][j] + max_dp[i-1][j+1]);
                    min_dp[i][j] = Math.min(nums[i][j] +  min_dp[i-1][j-1], nums[i][j] + min_dp[i-1][j]);
                    min_dp[i][j] = Math.min(min_dp[i][j], nums[i][j] + min_dp[i-1][j+1]);

                } else {
                    max_dp[i][j] = Math.max(nums[i][j] +  max_dp[i-1][j], nums[i][j] + max_dp[i-1][j-1]);
                    min_dp[i][j] = Math.min(nums[i][j] +  min_dp[i-1][j], nums[i][j] + min_dp[i-1][j-1]);
                }
            }

        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            max = Math.max(max, max_dp[N-1][i]);
            min = Math.min(min, min_dp[N-1][i]);
        }
        System.out.println(max + " " + min);

    }
}