import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		int temp = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = temp + Integer.parseInt(st.nextToken());
			temp = arr[i];
		}
		for(int a =0; a < M; a++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;

			int answer = arr[j];
			// a 가 0이라면 왼쪽 값을 빼 줄 필요가 없음 (인덱스 에러도 남)
			if(i > 0) {
				answer -= arr[i - 1];
			}
			System.out.println(answer);

		}
		
	}
}
