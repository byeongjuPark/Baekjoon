
import java.io.*;
import java.util.*;

public class Main {
	static int K;
	static int[] arr = new int[13];
	static int total;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st = null;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if(K == 0) {
				break;
			}
			for(int i = 0; i < K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			total = 0;
			result = new int[6];
			comb(0, 0);
            sb.append("\n");
		}
		System.out.println(sb.toString());

	}
	
	static void comb(int start, int depth) {
        // 6개 다 뽑았으면 출력
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        // start부터 N-1까지 돌면서 하나씩 뽑아보기
        for (int i = start; i < K; i++) {
        	result[depth] = arr[i];
            comb(i + 1, depth + 1); // 다음은 i+1부터 (중복 방지 + 오름차순 유지)
        }
    
	}

}
