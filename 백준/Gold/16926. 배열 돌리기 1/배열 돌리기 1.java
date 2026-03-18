import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배열 돌리기
public class Main {
	static int N, M, R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int array[][] = new int[N][M];
		for(int i = 0;  i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 돌려야 하는 줄 개 수
		int count = Math.min(N, M) / 2;
		
		// 회전 횟수
		for(int r = 0; r < R; r++) {
			// 줄 단위 반복문
			for(int k = 0; k < count; k++) {
				int temp = array[k][k]; // 임시 저장할 시작 지점
				// top 
                for(int i = 0; i < M - (2 * k) - 1; i++) {
                    array[k][i + k] = array[k][i + 1 + k]; 
                }
                // right
                for(int i = 0; i < N - (2 * k) - 1; i++) {
                    array[i + k][M - 1 - k] = array[i + 1 + k][M - 1 - k];
                }
                // bottom
                for(int i = M - (2 * k) - 1; i > 0 ; i--) {
                    array[N - 1 - k][i + k] = array[N - 1 - k][i - 1 + k];
                }
                // left
                for(int i = N - (2 * k) - 1; i > 0; i--) {
                    array[i + k][k] = array[i - 1 + k][k];
                }
//				printing(array);

				array[k+1][k] = temp;
				
				
				
			}
			
		}
		printing(array);
		
		
	}
	static void printing(int[][] s) {
//        System.out.println("---------------");
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }

}


