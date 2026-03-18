import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, R, C, map[][];
	static boolean visited[][][];
	static boolean hv[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] hdr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hdc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new ArrayDeque<int[]>();
		visited = new boolean[R][C][K+1];
		q.add(new int[] { 0, 0, 0, 0 }); // r,c,k,cnt
		visited[0][0][0] = true;
		min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int curR = q.peek()[0];
			int curC = q.peek()[1];
			int k = q.peek()[2];
			int cnt = q.peek()[3];
			q.poll();

			if (min < cnt)
				continue;
			if (curR == R - 1 && curC == C - 1) {
				// 도착
				min = Math.min(cnt, min);
				break;
			}
//			System.out.println(curR + "," + curC);
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if(isBoundery(nr, nc) && !visited[nr][nc][k] && map[nr][nc] != 1) {
					q.add(new int[] {nr, nc, k, cnt+1});
					visited[nr][nc][k] = true;
				}
			}
			
			if(k < K) {
				for (int d = 0; d < 8; d++) {
					int nr = curR + hdr[d];
					int nc = curC + hdc[d];
					if(isBoundery(nr, nc) && !visited[nr][nc][k+1] && map[nr][nc] != 1) {
						q.add(new int[] {nr, nc, k+1, cnt+1});
						visited[nr][nc][k+1] = true;
					}
				}				
			}
		}
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);			
		}

	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static void printing(int r, int c, int[][] map) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(i == r && j == c ? "* " : map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
