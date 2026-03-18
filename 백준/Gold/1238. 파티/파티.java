import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static List<List<Edge>> graph;
	static int V, E, P, result;
	static class Edge implements Comparable<Edge>{
		int to, cost;
		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Edge(to, cost));
		}
		
		
		result = 0;
		
		for(int i = 1; i < V+1; i++) {
			int goToParty = getMinDistance(i, P);
			int goToHome = getMinDistance(P, i);
			result = Math.max(result, goToParty + goToHome);
		}
		System.out.println(result);
		
	}
	
	static int getMinDistance(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
//			System.out.println(cur.to);
			if(dist[cur.to] < cur.cost) continue;
			
			for(Edge next : graph.get(cur.to)) {
				int nextCost = cur.cost + next.cost;
				
				if(nextCost > dist[next.to]) continue;
				dist[next.to] = nextCost;
				pq.add(new Edge(next.to, nextCost));
			}
		}
		
		return dist[end];
	}
}
