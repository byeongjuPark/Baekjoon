import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, A[], M, B[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		Arrays.sort(A);
		while(st.hasMoreTokens()) {
			int cur = Integer.parseInt(st.nextToken());
			sb.append(Arrays.binarySearch(A, cur) >= 0 ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}

}
