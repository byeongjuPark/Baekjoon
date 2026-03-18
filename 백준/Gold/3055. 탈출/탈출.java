
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, sR, sC;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static Queue<int[]> waterQueue; // 물 확산 큐

    public static void main(String[] args) throws IOException {
        init();
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        waterQueue = new ArrayDeque<>(); // 물 큐 초기화

        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if (map[i][j] == 'S') {
                    sR = i;
                    sC = j;
                }
                if (map[i][j] == '*') {
                    waterQueue.add(new int[]{i, j});
                }
            }
        }

        int result = bfs(sR, sC);
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    private static int bfs(int startR, int startC) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startR, startC, 0});

        while (!q.isEmpty()) {
            // 물 확산
            floodWater();

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curR = cur[0];
                int curC = cur[1];
                int dist = cur[2];

                if (visited[curR][curC]) continue;
                visited[curR][curC] = true;

                if (map[curR][curC] == 'D') return dist; // 도착 거리 반환

                for (int d = 0; d < 4; d++) {
                    int nr = curR + dr[d];
                    int nc = curC + dc[d];

                    if (isBoundery(nr, nc) && !visited[nr][nc] && map[nr][nc] != '*' && map[nr][nc] != 'X') {
                        q.add(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }
        return -1; // 탈출 불가 -1
    }

    static void floodWater() {
        int size = waterQueue.size();

        for (int i = 0; i < size; i++) {
            int[] water = waterQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = water[0] + dr[d];
                int nc = water[1] + dc[d];

                if (isBoundery(nr, nc) && map[nr][nc] == '.' && map[nr][nc] != 'D') { 
                    map[nr][nc] = '*';
                    waterQueue.add(new int[]{nr, nc}); 
                }
            }
        }
    }

    static boolean isBoundery(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
}
