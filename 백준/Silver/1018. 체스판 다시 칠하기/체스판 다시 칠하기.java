
import java.io.*;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
    static char[][] map;
    static int result;
    
    public static void main(String[] args) throws IOException {
        init();
        start();
    }
    
    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
    }
    
    static void start() {
        for(int i = 0; i <= N-8; i++) {
            for(int j = 0; j <= M-8; j++) {
                result = Math.min(result, calculateCost(i, j));
            }
        }
        System.out.println(result);
    }
    
    static int calculateCost(int x, int y) {
        int cost1 = 0; // 좌측 상단이 'B'일 때
        int cost2 = 0; // 좌측 상단이 'W'일 때

        char[][] pattern1 = { {'B', 'W'}, {'W', 'B'} };
        char[][] pattern2 = { {'W', 'B'}, {'B', 'W'} };
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(map[x+i][y+j] != pattern1[i % 2][j % 2]) cost1++;
                if(map[x+i][y+j] != pattern2[i % 2][j % 2]) cost2++;
            }
        }
        return Math.min(cost1, cost2);
    }
}
