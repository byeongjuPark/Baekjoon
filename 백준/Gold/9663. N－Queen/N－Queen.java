import java.util.Scanner;

// 퀸 배치 하기 
// 같은 행에 퀸을 두지 않는 방식
public class Main {
	static int N, col[], ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new int[N+1]; // 1행부터 사용
		setQueens(1);
		System.out.println(ans);
	}
	
	static void setQueens(int rowNo) {
		
		// 현재가 아닌 직전 선택까지의 선택을 검사 
		if(!isAvailable(rowNo-1)) return;
		
		if(rowNo>N) {
			// 무조건 답
			ans++;
			return;
		} 
		
		for(int c = 1; c <= N; c++) {
			col[rowNo] = c;
			setQueens(rowNo+1);
		}
	}
	static boolean isAvailable(int rowNo) {
		
		for(int k = 1; k < rowNo; k++) {
			if(col[rowNo] == col[k] || rowNo-k == Math.abs(col[rowNo]-col[k])) {
				// 열 확인 || 대각선 확인
				return false;
			}
		}
		
		return true;
	}
}
