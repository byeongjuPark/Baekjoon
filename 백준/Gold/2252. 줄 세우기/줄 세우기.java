
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int V, E, edgeCnt[];
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
	
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> edges = new ArrayList<>();
		for(int i = 0 ; i < V+1; i++) {
			edges.add(new ArrayList<>());
		}
		edgeCnt = new int[V+1];
		visited = new boolean[V+1];
		for(int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edges.get(from).add(to);
			edgeCnt[to]++;
		}
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i < V+1; i++) {
			if(edgeCnt[i] == 0) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			sb.append(cur).append(" ");
			
			for(Integer next :edges.get(cur)) {
				edgeCnt[next]--;
				
				if(edgeCnt[next] == 0) {
					q.add(next);
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}
