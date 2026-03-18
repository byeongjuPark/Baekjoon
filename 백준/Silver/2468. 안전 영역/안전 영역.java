import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], floodMap[][];
	static int maxHeight, minHeight, result;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		minHeight = Integer.MAX_VALUE;
		maxHeight = -1;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] < minHeight) {
					minHeight = map[i][j];
				}
				if(map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
		}
		result = 0;
		for(int h = minHeight-1; h < maxHeight; h++) {
			int count = 0;
			//영역 나누기
			floodMap = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] <= h) {
						floodMap[i][j] = 1;
					}
				}
			}
			// 영역 카운트
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(floodMap[i][j] == 0) {
						floodFill(i, j);
						count++;
					}
				}
			}
			result = Math.max(result, count);
		}
		System.out.println(result);

	}
	static void floodFill(int r, int c) {
		if(floodMap[r][c] == 1) return;
		if(visited[r][c]) return;
		
		visited[r][c] = true;
		floodMap[r][c] = 1;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isBoundery(nr, nc)) {
				floodFill(nr, nc);
			}
		}
	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
