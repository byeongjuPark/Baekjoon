import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, MAX_SQUARE_SIZE, MAX = 1;
	static int[][] map;
	static int[] points = new int[4];
	static int dr[] = {0, 0, 1, 1};
	static int dc[] = {0, 1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MAX_SQUARE_SIZE = Math.min(N, M);
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - 48;
			}
		}
		
//		print(map);
		
		for(int t = MAX_SQUARE_SIZE; t > 1; t--) {
			boolean exit = false;
			for(int r = 0; r < N; r++) {
				boolean isBoundery = true;
				for(int c = 0; c < M; c++) {

					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d] * (t-1);
						int nc = c + dc[d] * (t-1);
						
						if(!isBoundery(nr, nc)) {
							isBoundery = false;
							break;
						}
						
						points[d] = map[nr][nc];
					}
					
					if(isBoundery) {
						int temp = points[0];
						boolean square = true;
						for(int p = 1; p < 4; p++) {
							if(temp != points[p]) {
								square = false;
								break;
							}
						}
						if(square) {
							MAX = t;
							exit = true;
//							System.out.println(Arrays.toString(points));;
						}
						
					}
					if(exit) break;
				}
				if(exit) break;
			}
			if(exit) break;
		}
		System.out.println(MAX * MAX);
	}
	
	static boolean isBoundery(int r, int c) {
		return r < N && c < M && r >= 0 && c >= 0;
	}
	
	static void print(int[][] map) {
		System.out.println("---print---");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
				System.out.print(" ");
			}
		System.out.println();
		}
	}
}
