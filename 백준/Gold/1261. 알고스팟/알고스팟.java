
import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int R, C, map[][];
	static boolean[][] v;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		v = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		PriorityQueue<int[]> q = new PriorityQueue<int[]>((o1, o2) -> o1[2] - o2[2]);
		q.add(new int[] { 0, 0, 0 });

		int[][] dist = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		dist[0][0] = 0;

		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			int w = cur[2];

			if (r == R - 1 && c == C - 1) {
				System.out.println(w);
				return;
			}
//			System.out.println("v : " + r + ", " + c + "| " + w);
			if(dist[r][c] < w) continue; //이미 적은 비용일 경우

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isBoundery(nr, nc)) {
					int nw = w + map[nr][nc];
					if(nw < dist[nr][nc]) {
						dist[nr][nc] = nw;
						q.add(new int[] { nr, nc, nw });
					}
				}
			}
		}
	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
