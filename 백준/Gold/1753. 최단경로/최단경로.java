
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, SV;
	static int[] d;
	static boolean[] v;
	static List<Edge> list[];
	static class Edge implements Comparable<Edge>{
		int next;
		int w;
		public Edge(int next, int w) {
			super();
			this.next = next;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		SV = Integer.parseInt(br.readLine())-1; // 시작 노드
		list = new ArrayList[V];
		for(int i = 0; i < V; i++) {
			list[i] = new ArrayList<>();
		}
		d = new int[V];
		Arrays.fill(d, Integer.MAX_VALUE);
		v = new boolean[V];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Edge(v, w));
		}
		
		dijkstra(SV);
		
//		System.out.println(Arrays.toString(d));
		for(int i = 0; i < d.length; i++) {
			System.out.println(d[i] == Integer.MAX_VALUE ? "INF" : d[i]);
		}

	}
	
	static void dijkstra(int start) {
		d[start] = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(start, 0));
		
		
		while(!pq.isEmpty()) {
			int current = pq.peek().next;
			int distance = pq.peek().w;
			pq.poll();
			
			if (v[current]) continue;  // 이미 방문한 노드라면 스킵
			v[current] = true;  // 현재 노드를 방문 체크

			if(d[current] < distance) continue;
			for(int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i).next;
				int nextDistance = distance + list[current].get(i).w;
				
				if(nextDistance < d[next]) {
					d[next] = nextDistance;
					pq.add(new Edge(next, nextDistance));
				}
			}
		}
	
	}
	
}

  