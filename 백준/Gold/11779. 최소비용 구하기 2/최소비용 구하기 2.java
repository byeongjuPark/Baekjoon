

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int to, cost;
		List<Integer> path;

		public Edge(int to, int cost, List<Integer> path) {
			this.to = to;
			this.cost = cost;
			this.path = path;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
		
	}
	
	static int V, E, start, end;
	static List<List<Edge>> graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i = 0; i < V+1; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph.get(from).add(new Edge(to, cost, null));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 다익
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Edge(start, 0, new ArrayList<>()));
		pq.peek().path.add(start);
		List<Integer> resultPath = null;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if(dist[cur.to] < cur.cost) continue;
			
			for(Edge next : graph.get(cur.to)) {
				int nextCost = cur.cost + next.cost;
				if(nextCost < dist[next.to]) {
					dist[next.to] = nextCost;
					List<Integer> temp = new ArrayList<>();
					temp.addAll(cur.path);
					temp.add(next.to);
					pq.add(new Edge(next.to, nextCost, temp));
					if(next.to == end) {
						resultPath = temp;
					}
				}
			}
		}
		int result = dist[end];
		System.out.println(dist[end]);
		System.out.println(resultPath.size());
		for(Integer a : resultPath) {
			System.out.print(a + " ");
		}
		
	}
	
	
}
