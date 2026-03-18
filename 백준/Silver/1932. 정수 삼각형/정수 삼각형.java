import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, arr[][];
	static int delta[] = { 0, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int idx = 0;
		arr = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int loopSize = st.countTokens();
			for(int j = 0; j < loopSize; j++) {
				int a = Integer.parseInt(st.nextToken());
				for(int d = 0; d < 2; d++) {
					int before =  j + delta[d];
					if(before>=0) {
						// 범위에 들어오면
						// 합을 현재 값(i,j)과 비교
						// 큰 값 저장
						int parent = arr[i-1][before];
						if(parent + a > arr[i][j]) arr[i][j] = parent + a;
					}
					
				}
			}
			
		}
		int max = 0;
		for(int i = 0; i < N; i++) {
			max = Math.max(max, arr[N][i]);
		}
		System.out.println(max);
	}
}
