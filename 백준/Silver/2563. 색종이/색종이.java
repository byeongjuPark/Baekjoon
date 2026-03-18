import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int paperCount = Integer.parseInt(br.readLine());
		int result = 0;
		int grid[][] = new int[100][100];
		for (int k = 0; k < paperCount; k++) {
			String[] xyStr = br.readLine().split(" ");
			int x = Integer.parseInt(xyStr[0]);
			int y = Integer.parseInt(xyStr[1]);
			for (int i = x; i < x + 10; i++) {
				for (int j = y; j < y + 10; j++) {
					grid[i][j] = 1;
				}
			}
			
		}
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(grid[i][j] == 1) {
					result++;
				}
			}
		}
		
//		for(int i = 0; i < 100; i++) {
//			for(int j = 0; j < 100; j++) {
//				System.out.print(grid[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(result);
	}
}