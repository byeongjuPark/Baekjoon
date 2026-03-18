import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, max;
    static char[][] map;
    static int[][] delta = { { -1, 1 }, { 0, 1 }, { 1, 1 }};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i = 0; i < R; i++) {
            String temp = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        max = 0;
        visited = new boolean[R][C];
        
        // 각 행에서 파이프를 설치할 수 있는지 확인
        for (int i = 0; i < R; i++) {
            if (find(i, 0)) {
                max++;  // 파이프 설치에 성공하면 최대 카운트를 증가
            }
        }
        System.out.println(max);
    }

    // 경로 찾는 dfs
    static boolean find(int row, int col) {
        visited[row][col] = true;

        if (col == C - 1) {
            return true;  // 마지막 열에 도달했으면 성공
        }

        for (int d = 0; d < 3; d++) {
            int nr = row + delta[d][0];
            int nc = col + delta[d][1];
            if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != 'x' && !visited[nr][nc]) {
                if (find(nr, nc)) {
                    return true;  // 성공하면 바로 종료
                }
            }
        }
        
        return false;  // 가능한 경로가 없으면 실패
    }
}
