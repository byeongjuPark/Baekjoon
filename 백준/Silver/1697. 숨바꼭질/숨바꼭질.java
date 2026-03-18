

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] check = new int[100001];
		if (N == K) {
            System.out.println(0);
            return;
        }
		// N->K 구도
		Queue<Integer> q = new ArrayDeque<>();
		q.add(N);
		check[N] = 1;

		while(!q.isEmpty()) {
			int cur = q.poll();
			
			int[] nexts = {cur-1, cur+1, cur << 1};
			for(int next : nexts) {
				if(next < 0 || next > 100000) continue;
				if(check[next] != 0) continue;
				
				check[next] = check[cur] + 1;
				
				if(next == K) {
					System.out.println(check[next]-1);
					return;
				}
				q.add(next);
			}
		}
		
	}
}
