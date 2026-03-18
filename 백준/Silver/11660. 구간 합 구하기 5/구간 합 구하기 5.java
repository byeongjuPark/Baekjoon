
import java.io.*;
import java.util.*;


public class Main {
	static int N, M, map[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				sum += Integer.parseInt(st.nextToken());
				map[i][j] = sum;
			}
		}
		for(int i = 1; i < N+1; i++) {
			map[i][0] = map[i-1][N];
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int s = 0;
			for(int i = x1; i <= x2; i++) {
				s += map[i][y2] - map[i][y1-1];
			}
			System.out.println(s);
		}
//		for(int i = 0; i < N+1; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
	}
}
