
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static int[][] map;
	static int inputs[];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int input = Integer.parseInt(st.nextToken());
			for (int h = 0; h < input; h++) {
				map[h][i] = 1;
			}
		}

//		print();
		result = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 0) {
					// 좌 우 탐색 해서 카운트 여부체크
					boolean left = false;
					boolean right = false;
					for (int l = j - 1; l >= 0; l--) {
						if (isBoundery(i, l) && map[i][l] == 1) {
							left = true;
							break;
						}
					}
					for (int r = j + 1; r < W; r++) {
						if (isBoundery(i, r) && map[i][r] == 1) {
							right = true;
							break;
						}
					}
//					System.out.println("(" + i + "," + j + ")");
//					System.out.println("l :" + left + ", r :" + right);
					if (left && right)
						result++;
				}
			}
		}
		System.out.println(result);

	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < H && c < W;
	}

	static void print() {
		System.out.println("______________");
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
