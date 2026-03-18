import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] map;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		System.out.println(man() + " " + redGreenMan());
	}
	static int man() {
		int cnt = 0;
		char[][] cloneMap = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cloneMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char target = cloneMap[i][j];
				if (target != '0') {
					floodFill(i, j, target, cloneMap);
					cnt++;
				}
			}
		}
		return cnt;
		
	}
	static int redGreenMan() {
		int cnt = 0;
		char[][] cloneMap = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cloneMap[i][j] = map[i][j];
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(cloneMap[i][j] == 'G') {
					cloneMap[i][j] = 'R';
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char target = cloneMap[i][j];
				if (target != '0') {
					floodFill(i, j, target, cloneMap);
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void floodFill(int i, int j, char target, char[][] cloneMap) {
		if (!isBoundery(i, j))
			return;
		if (cloneMap[i][j] != target)
			return;

		cloneMap[i][j] = '0';

		for (int d = 0; d < 4; d++) {
			int nr = i + delta[d][0];
			int nc = j + delta[d][1];
			floodFill(nr, nc, target, cloneMap);
		}
	}

	static boolean isBoundery(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < N;
	}

}
