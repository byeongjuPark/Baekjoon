import java.io.*;
import java.util.*;
public class Main
{
    private static int[] dr = {1, -1, 0, 0};
    private static int[] dc = {0, 0, 1, -1};
    private static char[][] map;
    private static boolean[][] visited;
    private static int N, M;
    private static int answer = 999999;
    public static void main(String[] args) throws IOException
    {
        // 미로 1 : 이동 가능 / 0 : 이동 불가능
        // 1, 1 출발
        // N, M의 위치로 이동까지의 최소 칸 수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j);;
            }
        }

        int startR = 0;
        int startC = 0;
        bfs(startR, startC, 1);
        System.out.println(answer);
    }

    private static void bfs(int r, int c, int cnt){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c, cnt});
        while(!q.isEmpty()){
            int[] a = q.poll();
            int curR = a[0];
            int curC = a[1];
            int curCnt = a[2];
            if(curR == N-1 && curC == M-1){
                answer = curCnt;
                return;
            }
            if(visited[curR][curC]){
                continue;
            }
            visited[curR][curC] = true;
            for(int d = 0; d < 4; d++){
                int nr = curR + dr[d];
                int nc = curC + dc[d];
                if(isBoundery(nr, nc) && !visited[nr][nc] && map[nr][nc] == '1'){
                    q.add(new int[]{nr, nc, curCnt+1});
                }
            }
        }
        
    }


    private static boolean isBoundery(int r, int c){
        return r >= 0 && c >=0 && r < N && c < M;
    }
}