import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ArrayList<Edge>[] graph = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] dist = getDistances(start, end, graph);
		System.out.println(dist[end]);
	}
	
	static int[] getDistances(int start, int end, List<Edge>[] graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();

			if(dist[cur.to] < cur.weight) {
				continue;
			}
			
			for(Edge next : graph[cur.to]) {
				int nVertex = next.vertex;
				int nWeight = next.weight;
				int tempWeight = nWeight + dist[cur.to];
				if(tempWeight < dist[nVertex]) {
					dist[nVertex] = tempWeight;
					pq.add(new Node(nVertex, nWeight));
				}
			}
		}
		
		return dist;
		
		
	}
	static class Node implements Comparable<Node>{
		int to, weight;

		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static class Edge implements Comparable<Edge>{
		int vertex, weight;

		public Edge(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
