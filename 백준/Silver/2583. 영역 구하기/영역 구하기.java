import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	static int M, N, K;
	static int[][] map;
	static int delta[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static ArrayList<Integer> sizeList = new ArrayList<>();
	static int tempSize = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			int[] end = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			for(int i = start[0] ; i < end[0]; i++) {
				for(int j = start[1]; j < end[1]; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		int cnt = 0; 
		for(int i = 0 ; i < M; i++) {
			for(int j = 0 ; j  < N; j ++) {
				if(map[i][j] == 0) { 
					floodFill(i, j, 0);
					sizeList.add(tempSize);
					tempSize = 0;
					cnt++;
				}
			}
		}
		Collections.sort(sizeList);
		
		System.out.println(cnt);
		for(int i = 0; i < sizeList.size(); i++) {
			System.out.print(sizeList.get(i)+" ");
		}
		
//		printing(map);
		
	}
	
	static void floodFill(int r, int c, int size) {
		if(!isBoundery(r, c)) return;
		if(map[r][c] != 0) return;
		
		map[r][c] = 1;
		tempSize++;
		
		for(int d = 0 ; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			floodFill(nr, nc, size);
		}
		
		
	}
	
	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < M && c < N;
	}
	static void printing(int[][] m) {
		System.out.println("__________________");
		for(int i = 0 ; i < m.length; i++) {
			for(int j = 0 ; j < m[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
