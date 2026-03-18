import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt;
	static char[][] map;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int startRow;
	static int startCol;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j] == 'I') {
					startRow = i;
					startCol = j;
				}
			}
		}
		visited = new boolean[N][M];
		dfs(startRow, startCol);
		System.out.println(cnt == 0 ? "TT" : cnt);
		
	}
	static void dfs(int r, int c) {

//		System.out.println(r+","+c);
		if(map[r][c] == 'X') return;
		if(map[r][c] == 'P') cnt++;
		
		visited[r][c] = true;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isBoundery(nr, nc) && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}
