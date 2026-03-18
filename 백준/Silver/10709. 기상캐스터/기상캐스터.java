
import java.util.*;
import java.io.*;

public class Main {
	static int H, W;
	static char[][] map;
	static int[][] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		result = new int[H][W];
		for(int i = 0; i < H; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				int cnt = 0;
				boolean notFound = true;
				for(int k = j; k >= 0; k--) {
					if(map[i][k] != 'c') {
						cnt++;
						continue;
					} 
					
					if(map[i][k] == 'c') {
						notFound = false;
						result[i][j] = cnt;
						break;
					}

				}
				if(notFound) {
					result[i][j] = -1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
