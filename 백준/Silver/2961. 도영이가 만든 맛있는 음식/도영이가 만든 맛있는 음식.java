
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	static boolean[] isSelected;
	static int bit;
	static int things[][];
	static int result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		things = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken());
			things[i][1] = Integer.parseInt(st.nextToken());
		}
		bit = 0;
		isSelected = new boolean[N];
		result = Integer.MAX_VALUE;
		sub(0);
		System.out.println(result);
	}

	
static void sub(int cnt) {
		
		if(cnt == N) {
			// 부분집합 완성
			
			// 한개도 안고를 경우 뺴야함.
			boolean allFalse = true;
			for(int i = 0; i < N; i++) {
//				if(isSelected[i]) {
				if((bit&(1<<i))!=0 ) {
					allFalse = false;
				} 
			}
			if(allFalse) return;
			
			int sour = 1;
			int bitter = 0;
			for(int h = 0; h < N; h++) {
//				if(isSelected[h]) {
				if((bit&(1<<h))!=0 ) {
					sour*=things[h][0];
					bitter+=things[h][1];
				}
			}
			int temp = Math.abs(sour-bitter);
			result = Math.min(temp, result);
//			System.out.println(Arrays.toString(isSelected));
			
			return;
		}
		
		
//		isSelected[cnt] = true;
		bit = bit | (1 << cnt);
		sub(cnt+1);
//		isSelected[cnt] = false;
		bit = bit  &~(1 << cnt);
		sub(cnt+1);
	}
}

