import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] map;
	static int count, time;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static ArrayList<int[]> removeList;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		init();
		start();
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static void start() {
		boolean flag = true;
		time = 0;
		count = counting();
		
		while (count != 0) {
			removeList = new ArrayList<>();
			visited = new boolean[R][C];
			time++;
			
			floodFill(0, 0);
			oxidize(); // 산화
			int tempCnt = counting(); // 남은 치즈 수 카운트
			if(tempCnt == 0) break;
			count = tempCnt;
			// 개수 검사
		}
		
		System.out.println(time);
		System.out.println(count);
	}

	static void floodFill(int r, int c) {
		if(!isBoundery(r, c)) return;
		if(map[r][c] == 1) {
			removeList.add(new int[] {r, c});
			return;
		}
		if(visited[r][c]) return;
		
		visited[r][c] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			floodFill(nr, nc);
		}
	}
	
	static void oxidize() {
		for(int[] a : removeList) {
			map[a[0]][a[1]] = 0;
		}
	}
	
	static int counting() {
		int result = 0;
		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 1) result++;
			}
		}
		return result;
	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
