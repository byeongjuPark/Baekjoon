import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int T,N, count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 1 ; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			count = 0;
			rec(0);
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void rec(int sum) {
		if(sum > N) return;
		if(sum == N) {
			count++;
			return;
		} else {
			for(int i = 1; i <= 3 ; i++) {
				rec(sum+i);
			}
		}
	}
}
