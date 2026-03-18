
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
//	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int T, N, M, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t= 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < M; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
			for(int i = 0; i < C; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						floodFill(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void floodFill(int r, int c) {
		if (!isBoundery(r, c))
			return;
		if (map[r][c] == 0)
			return;

		//
		map[r][c] = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			floodFill(nr, nc);
		}

	}

	static boolean isBoundery(int r, int c) {
		return r < N && c < M && r >= 0 && c >= 0;
	}
}
