
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, startV, endV;
	static ArrayList<ArrayList<int[]>> graph;
	static boolean[] visited;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		for(int i = 0; i < N+1; i++) { // N+1 Vertex start 1
			graph.add(new ArrayList<int[]>());
		}
		StringTokenizer st = null;
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // start
			int e = Integer.parseInt(st.nextToken()); // end
			int c = Integer.parseInt(st.nextToken()); // cost
			
			graph.get(s).add(new int[] {e, c}); // 도착지와 비용 
		}
		st = new StringTokenizer(br.readLine());
		startV = Integer.parseInt(st.nextToken());
		endV = Integer.parseInt(st.nextToken());
		
		int result = getMinCost();
		System.out.println(result);
	}

	
	static int getMinCost() {
		dp = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		// 시작 지점 설정 
		// dp테이블 설정 
		dp[startV] = 0;
		// 큐에 넣기
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
		q.add(new int[] {startV, 0});
		
		while(!q.isEmpty()) {
			int cur[] = q.poll();
			int curVertex = cur[0];
			int cost = cur[1];
			
			if (visited[curVertex]) continue;
            visited[curVertex] = true;
			
			// 다음 위치 찾아서 큐에 넣기
			for(int[] ec : graph.get(curVertex)) {
				// dp테이블의 값보다 작은 거리값의 합이면 덮어씌움
				int e = ec[0];
				int c = ec[1];
				int nCost = cost + c;
				if(dp[e] > nCost) {
					dp[e] = nCost;
				}
				if(!visited[e] && dp[e] != Integer.MAX_VALUE) {
					q.add(new int[] {e, dp[e]});
				}
			}
			
		}
		
		return dp[endV];
	}
}
