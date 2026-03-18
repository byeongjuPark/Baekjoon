
import java.io.*;
import java.util.*;

public class Main {
	private static int N, M;
	private static int[] A;
	private static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		// 투포인터 & 윈도우 슬라이딩
		int sum = 0;
		int left = 0, right = 0;
		// left와 right가 N-1에 도달하면 break;
		while (true) {
			if (sum >= M) {
                if (sum == M) result++;
                sum -= A[left++];          
            } else { // sum < M
                if (right == N) break;     
                sum += A[right++];        
            }
		}

		System.out.println(result);
	}

}
