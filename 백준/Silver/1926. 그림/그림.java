
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		init();
	}

	static int N, M, map[][], cnt, cnt2;
	static boolean[][] visited;
	static int dr[] = { 1, -1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		cnt2= 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cnt2++;
					cnt = 0;
					floodFill(i, j);
//					print();
				}
				result = Math.max(cnt, result);
			}
		}
		sb.append(cnt2).append("\n").append(result);
		System.out.println(sb);
	}
	
	static void print() {
		System.out.println("______________");
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void floodFill(int r, int c) {
//
//		if (!isBoundery(r, c))
//			return;
//		if (visited[r][c])
//			return;
//		if (map[r][c] == 0)
//			return;

		visited[r][c] = true;
		map[r][c] = 0;
		cnt++;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!isBoundery(nr, nc)) continue;
			if(!visited[nr][nc] && map[nr][nc] != 0) {
				floodFill(nr, nc);
			}
		}

	}

	private static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
