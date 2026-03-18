

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, map[][];
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String temp = br.readLine();
			for(int j = 0 ; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
		
	}
	
	static int bfs() {
	    Queue<int[]> q = new ArrayDeque<>();
	    boolean[][][] visited = new boolean[N][M][2]; // 3차원 배열로 방문 체크
	    q.add(new int[] {0, 0, 1, 0}); // r, c, cnt, break

	    while (!q.isEmpty()) {
	        int[] current = q.poll();
	        int r = current[0];
	        int c = current[1];
	        int cnt = current[2];
	        int brk = current[3];

	        // 목적지 도달 확인
	        if (r == N - 1 && c == M - 1) {
	            return cnt;
	        }

	        for (int d = 0; d < 4; d++) {
	            int nr = r + dr[d];
	            int nc = c + dc[d];

	            if (isBoundery(nr, nc)) {
	                // 벽을 만나지 않았을 때
	                if (map[nr][nc] == 0 && !visited[nr][nc][brk]) {
	                    visited[nr][nc][brk] = true;
	                    q.add(new int[] {nr, nc, cnt + 1, brk});
	                }
	                // 벽을 만나고, 아직 벽을 부순 적이 없을 때
	                else if (map[nr][nc] == 1 && brk == 0 && !visited[nr][nc][1]) {
	                    visited[nr][nc][1] = true;
	                    q.add(new int[] {nr, nc, cnt + 1, 1});
	                }
	            }
	        }
	    }

	    return -1; // 도달 불가능할 경우 -1 반환
	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
