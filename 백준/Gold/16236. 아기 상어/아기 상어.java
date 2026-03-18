import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt, map[][], sharkPos[];
    static int sharkLevel, sharkExp;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

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
                    map[i][j] = 0; // 상어가 있던 자리는 빈칸으로
                }
            }
        }
        sharkLevel = 2; // 처음 아기상어 크기는 2
        bfs();
        System.out.println(cnt); 
    }

    static void bfs() {
        while (true) {
            int[] target = findMeat();  // 물고기 탐색
            if (target == null) {
                break;  //  물고기 없으면 종료
            }

            boolean[][] visited = new boolean[N][N];
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{sharkPos[0], sharkPos[1], 0});
            visited[sharkPos[0]][sharkPos[1]] = true;

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                int time = cur[2];

                // 먹이 위치에 도달하면 처리
                if (r == target[0] && c == target[1]) {
                    map[r][c] = 0;  // 물고기 먹음
                    cnt += time;  // 시간 누적
                    addSharkExp();
                    sharkPos[0] = r;  // 상어 위치 갱신
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

            if (dist > minDist) {
                break;
            }

            // 물고기 발견
            if (map[r][c] != 0 && map[r][c] < sharkLevel) {
                if (dist < minDist) {
                    minDist = dist;
                    target = new int[]{r, c, dist};
                } else if (dist == minDist) {
                    // 같은 거리에 있다면 더 위쪽, 왼쪽에 있는 물고기 선택
                    if (r < target[0] || (r == target[0] && c < target[1])) {
                        target = new int[]{r, c, dist};
                    }
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
