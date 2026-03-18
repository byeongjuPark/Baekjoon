import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, map[][], distance[][];
	static boolean v[][];
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0; 
		while (true) {
			cnt++;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			if (N == 0)
				break;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append("Problem ").append(cnt).append(": ").append(getMinDistance(0,0,N-1,N-1)).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	

	static int getMinDistance(int sr, int sc, int er, int ec) {
		int INF = Integer.MAX_VALUE;
		v = new boolean[N][N];
		distance = new int[N][N];
		PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], INF);
		}

		distance[sr][sc] = map[sr][sc];
		pQueue.offer(new int[] { sr, sc , distance[sr][sc]});

		while (!pQueue.isEmpty()) {
			int[] cur = pQueue.poll();
			int r = cur[0];
			int c = cur[1];
			int cost = cur[2];

			if (v[r][c])
				continue; // 방문했으면 패스
			
			v[r][c] = true;
			
			if(r == er && c == ec) return cost;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isBoundery(nr, nc) 
						&& !v[nr][nc] 
						&& distance[nr][nc] > cost + map[nr][nc]) {
					
					distance[nr][nc] = cost + map[nr][nc];
					pQueue.offer(new int[] {nr, nc, distance[nr][nc]});
				}
			}

		}

		return -1;

	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}

}
