

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, startV;
	static int[] dist;
	static boolean[] visited;
	static List<List<Edge>> graph;
	
	static class Edge implements Comparable<Edge>{
		int to, cost;
		public Edge(int to, int cost) {
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
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()) + 1;
		E = Integer.parseInt(st.nextToken());
		startV = Integer.parseInt(br.readLine());
		dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		graph = new ArrayList<>();
		for(int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(from).add(new Edge(to, cost));
		}
		
		setDistance(startV);
		for(int i = 1; i < V; i++) {
			System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
		}
	}
	
	
	static void setDistance(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		dist[start] = 0;
		visited = new boolean[V];
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			int curV = cur.to;
			int curCost = cur.cost;
			
			if(visited[curV]) continue;
			visited[curV] = true;
			if(dist[curV] < curCost) continue;
			dist[curV] = curCost;
			
			for(Edge nextV : graph.get(curV)) {
				pq.add(new Edge(nextV.to, curCost + nextV.cost));
			}
			
		}
	}
}
