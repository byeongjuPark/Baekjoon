

import java.io.*;
import java.util.StringTokenizer;

//정사각형 모양을 한 다섯 종류의 색종이가 있다. 
//색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 
//각 종류의 색종이는 5개씩 가지고 있다.
public class Main {
	private static int[][] paper;
	private static int[] paperCnt = { 0, 5, 5, 5, 5, 5 };
	private static int result = Integer.MAX_VALUE;
	private static int[] dr = { 1, -1, 0, 0 };
	private static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		boolean hasFirst = true;
		int fr = -1, fc = -1;
		paper = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if (hasFirst && paper[i][j] == 1) {
					fr = i;
					fc = j;
					hasFirst = false;
				}
			}
		}

		DFS(fr, fc, 0);

		if (result == Integer.MAX_VALUE) {
			result = -1;
		}

		System.out.println(result);
	}

	private static void DFS(int r, int c, int cnt) {
		// 가지치기
		if (cnt >= result)
			return;

		// 모두 덮었으면 갱신
		if (isClear()) {
			result = Math.min(result, cnt);
			return;
		}

		// 현재 r,c가 1이 아닐 수도 있으니 항상 보드에서 다음 1을 다시 찾기
		int[] cur = nextPos();
		int cr = cur[0], cc = cur[1];
		if (cr == -1) {
			result = Math.min(result, cnt);
			return;
		}

		// 큰 색종이부터 시도 (5 -> 1)
		for (int p = 5; p >= 1; p--) {
			if (paperCnt[p] == 0)
				continue;
			if (!canAttach(cr, cc, p))
				continue;

			attach(cr, cc, p);
			paperCnt[p]--;

			if (isClear()) {
				result = Math.min(result, cnt + 1);
				paperCnt[p]++;
				detach(cr, cc, p);
				continue;
			}

			// 아직 남아있으면 다음 1에서 계속
			DFS(cr, cc, cnt + 1);

			paperCnt[p]++;
			detach(cr, cc, p);
		}
	}

	private static boolean isClear() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (paper[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	private static int[] nextPos() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (paper[i][j] == 1)
					return new int[] { i, j };
			}
		}
		return new int[] { -1, -1 };
	}

	private static boolean isBoundery(int r, int c) {
		return r < 10 && r >= 0 && c < 10 && c >= 0;
	}

	private static boolean canAttach(int r, int c, int size) {
		boolean res = true;
		if (paperCnt[size] <= 0)
			return false;
		if (r + size > 10 || c + size > 10)
			return false; // 범위 검사
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (paper[i][j] == 0) { // 종이를 붙일 수 없는 곳 또는 이미 붙은 곳 검사
					return false;
				}
			}
		}
		return res;
	}

	private static void attach(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = 0;
			}
		}
	}

	private static void detach(int r, int c, int size) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				paper[i][j] = 1;
			}
		}
	}

}
