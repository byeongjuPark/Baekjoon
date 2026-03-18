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
    static Queue<int[]> q;
    static boolean[][] visited;

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
        int resultTime = 0;

        while (true) {
            q = new ArrayDeque<>();
            visited = new boolean[N][M];
            
            if (isDone()) break;
            else resultTime++;

            floodFill(0, 0);

            // 녹이기
            for (int[] cur : q) {
                int i = cur[0];
                int j = cur[1];
                map[i][j] = 0;
            }
        }
        System.out.println(resultTime);
    }

    static void floodFill(int r, int c) {
        Queue<int[]> floodQueue = new ArrayDeque<>();
        floodQueue.add(new int[] { r, c });
        visited[r][c] = true;

        while (!floodQueue.isEmpty()) {
            int[] cur = floodQueue.poll();
            int curR = cur[0];
            int curC = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = curR + dr[d];
                int nc = curC + dc[d];

                if (isBoundery(nr, nc)) {
                    if (map[nr][nc] == 1 && isMelting(nr, nc)) {
                        q.add(new int[] { nr, nc }); // 녹을 치즈 큐에 추가
                    } else if (map[nr][nc] == 0 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        floodQueue.add(new int[] { nr, nc }); // 공기 공간을 계속 탐색
                    }
                }
            }
        }
    }

    static boolean isMelting(int r, int c) {
        int airCount = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (isBoundery(nr, nc) && map[nr][nc] == 0 && visited[nr][nc]) {
                airCount++;
            }
        }

        return airCount >= 2;
    }

    static boolean isBoundery(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static boolean isDone() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
