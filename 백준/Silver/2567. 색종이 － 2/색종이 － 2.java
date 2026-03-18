import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] table = new int[100][100];
	static int n;
	static int[][] paper;
	static int result;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) throws IOException {
		init();
		start();
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		paper = new int[n][2];

		StringTokenizer st;
		for (int i = 0; i < paper.length; i++) {
			st = new StringTokenizer(br.readLine());
			paper[i][0] =Integer.parseInt(st.nextToken());
			paper[i][1] =Integer.parseInt(st.nextToken());
		}
	}

	static void start() {
		for(int t = 0; t < n ; t++) {
			// 종이
			int r = paper[t][0];
			int c = paper[t][1];
			
			for(int i = r; i < r+10; i++) {
				for(int j = c; j < c+10; j++ ) {
					table[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(table[i][j] == 0) {
					continue;
				} else if(table[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						int nr = i + delta[k][0];
						int nc = j + delta[k][1];
						if(nr < 0 || nc < 0 || nr >= 100 || nc >= 100 || table[nr][nc] == 0) {
							result++;
							
						}
						
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
