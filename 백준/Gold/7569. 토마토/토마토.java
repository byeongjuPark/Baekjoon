import java.util.*;
import java.io.*;

public class Main {
    static int M, N, H, map[][][];
    static int[] dr = {1, -1, 0, 0, 0, 0};
    static int[] dc = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static boolean[][][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(result);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        visited = new boolean[H][N][M];

        Queue<int[]> q = new ArrayDeque<>();
        
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[k][i][j] = Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) {
                        q.offer(new int[]{k, i, j}); // 익은 토마토의 위치 큐에 저장
                        visited[k][i][j] = true;
                    }
                }
            }
        }
        bfs(q); // bfs 함수에 초기 큐 전달
    }

    static void bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int h = cur[0], r = cur[1], c = cur[2];

                for (int d = 0; d < 6; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    int nh = h + dh[d];
                    
                    if (isBoundery(nr, nc, nh) && map[nh][nr][nc] == 0 && !visited[nh][nr][nc]) {
                        map[nh][nr][nc] = 1;
                        visited[nh][nr][nc] = true;
                        q.offer(new int[]{nh, nr, nc});
                    }
                }
            }
            result++;
        }

        if (!isDone()) {
            result = -1;
        } else {
            result--; // 마지막에 더해진 시간을 제외
        }
    }

    static boolean isDone() {
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean isBoundery(int r, int c, int h) {
        return r >= 0 && c >= 0 && h >= 0 && r < N && c < M && h < H;
    }
}
