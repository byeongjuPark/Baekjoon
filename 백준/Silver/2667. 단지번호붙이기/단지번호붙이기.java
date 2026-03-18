import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int N, map[][],islandCnt, count;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		islandCnt = 1;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j <N;j++) {
				if(map[i][j] == 1) {
					islandCnt++;
					count = 0;
					floodFill(i, j, islandCnt);
					list.add(count);
				}
			}
		}
		System.out.println(islandCnt-1);
		Collections.sort(list);
		for(Integer i : list) {
			System.out.println(i);
		}
	}
	static void floodFill(int r, int c, int islandCnt) {
		if(!isBoundery(r, c)) return;
		if(map[r][c] != 1) return;
		
		map[r][c] = islandCnt;
		count++;
		
		for(int d = 0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			floodFill(nr, nc, islandCnt);
		}
		
	}
	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
		
}
