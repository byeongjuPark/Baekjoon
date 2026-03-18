
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
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		// 
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = i; j < N; j++) {
				sum += A[j];

				if(sum == M) result++;
				if(sum > M) break;
			}
		}
		
		System.out.println(result);
	}
}
