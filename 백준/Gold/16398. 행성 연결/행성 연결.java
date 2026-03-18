import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	
	static int[] parents;
	static PriorityQueue<Edge> edges;
	
	static void make() {
		parents = new int[N];
		edges = new PriorityQueue<>();
		for(int i = 0 ; i < N; i++) parents[i] = i;
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		make();
		
		for(int i = 0 ; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				if(i == j) {
					st.nextToken();
					continue;
				}
				if(i < j) {
					st.nextToken();
					continue;
				}
				long weight = Long.parseLong(st.nextToken());
				edges.add(new Edge(i, j, weight));
				edges.add(new Edge(j, i, weight));
			}
		}
		long cost = 0;
		while(!edges.isEmpty()) {
			Edge e = edges.poll();
			if(union(e.from, e.to)) {
				cost += e.weight;
			}
		}
		
		System.out.println(cost);
	}
	
	
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight, o.weight);
		}
		
	}
}
