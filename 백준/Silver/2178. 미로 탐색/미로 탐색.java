
import java.io.*;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	static int N, M;
	static int result;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			char[] arr = new StringTokenizer(br.readLine()).nextToken().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = arr[j] - '0';
			}
		}

		result = Integer.MAX_VALUE;

		bfs();
		
		System.out.println(result);
	}

	static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		int startR = 0;
		int startC = 0;
		q.add(new int[] { startR, startC, 1 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curR = cur[0];
			int curC = cur[1];
			int cnt = cur[2];
			
			if(curR == N-1 && curC == M-1) {
				result = Math.min(result, cnt);
			}

			
			
			for (int d = 0; d < 4; d++) {
				int nr = curR + dr[d];
				int nc = curC + dc[d];
				if (isBoundery(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					q.add(new int[] { nr, nc, cnt + 1 });
					visited[nr][nc] = true;
				}
			}

		}
		
		

	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

}
