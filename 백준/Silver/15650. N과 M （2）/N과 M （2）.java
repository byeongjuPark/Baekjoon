
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	static int[] numbers;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[M];
		
		dfs(0, 1);
		
		System.out.println(sb.toString());
	}
	static void dfs(int cnt, int start) {
		if(cnt == M) {
//			Collections.sort(numbers);
			for(int i : numbers) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			dfs(cnt + 1, i+1);
		}
	}
}
