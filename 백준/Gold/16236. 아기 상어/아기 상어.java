import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt, map[][], sharkPos[], sharkLevel, sharkExp;
    static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        init();
    }
    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sharkPos = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkPos[0] = i;
                    sharkPos[1] = j;
                    map[i][j] = 0;
                }
            }
        }
        sharkLevel = 2; 
        bfs();
        System.out.println(cnt); 
    }
    static void bfs() {
        while (true) {
            int[] target = findMeat();
            if (target == null) break;
            boolean[][] visited = new boolean[N][N];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{sharkPos[0], sharkPos[1], 0});
            visited[sharkPos[0]][sharkPos[1]] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int time = cur[2];
                if (r == target[0] && c == target[1]) {
                    map[r][c] = 0;
                    cnt += time;
                    addSharkExp();
                    sharkPos[0] = r;
                    sharkPos[1] = c;
                    break;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (isBoundery(nr, nc) && !visited[nr][nc] && map[nr][nc] <= sharkLevel) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc, time + 1});
                    }
                }
            }
        }
    }

    static int[] findMeat() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new int[]{sharkPos[0], sharkPos[1], 0});
        visited[sharkPos[0]][sharkPos[1]] = true;
        int minDist = Integer.MAX_VALUE;
        int[] target = null;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            if (dist > minDist) break;
            if (map[r][c] != 0 && map[r][c] < sharkLevel) {
                if (dist < minDist) {
                    minDist = dist;
                    target = new int[]{r, c, dist};
                } else if (dist == minDist) {
                    if (r < target[0] || (r == target[0] && c < target[1])) target = new int[]{r, c, dist};
                }
            }
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isBoundery(nr, nc) && !visited[nr][nc] && map[nr][nc] <= sharkLevel) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                }
            }
        }

        return target;
    }
    private static boolean isBoundery(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
    private static void addSharkExp() {
        sharkExp++;
        if (sharkExp == sharkLevel) {
            sharkLevel++;
            sharkExp = 0;
        }
    }
}
