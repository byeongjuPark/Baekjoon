import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static boolean visited[][];
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int time = 0;
		
		
		while (true) {
			// 섬 세기
			q = new ArrayDeque<>();
			visited = new boolean[N][M];
			int islandCnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						floodFill(i, j);
						islandCnt++;
					}

				}
			}
			if (islandCnt >= 2) {
				break;
			} else if(islandCnt == 0) {
                // 섬의 개수가 처음부터 작을 경우.
				time = 0;
				break;
			}

			time++;

			// 빙산 깎기
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];
				int w = cur[2];
				map[r][c] -= w;
				if (map[r][c] < 0)
					map[r][c] = 0;
			}
		}

		System.out.println(time);
	}

	static void floodFill(int r, int c) {
		if (visited[r][c])
			return;

		visited[r][c] = true;

		int waterCnt = 0;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (isBoundery(nr, nc) && map[nr][nc] != 0) {
				floodFill(nr, nc);
			}

			// 큐에 섬도 담아준다.
			// 4방 탐색으로 바다물이 몇개 접해있는지 확인
			if (isBoundery(nr, nc)) {
				if (map[nr][nc] == 0) {
					waterCnt++;
				}
			}
		}
		q.offer(new int[] { r, c, waterCnt });

	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

}
