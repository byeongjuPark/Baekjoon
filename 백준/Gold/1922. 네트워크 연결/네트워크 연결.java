
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge>{
		int from, to, cost;
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	static int parents[];
	static int N, M, result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		result = 0;
		make();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			pq.offer(new Edge(from, to, cost));
		}
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(union(cur.from, cur.to)) {;
				result += cur.cost;
			}
		}
		System.out.println(result);
	}
	static void make() {
		parents = new int[N+1];
		for(int i = 0 ; i < N+1; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[aRoot] = bRoot;
		return true;
	}
}
