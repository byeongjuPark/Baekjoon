import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, parents[];
	static long totalCost;
	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		make();
		PriorityQueue<Edge> pq = new PriorityQueue<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			totalCost += cost;
			pq.add(new Edge(from, to, cost));
		}
		long result = 0;
		while (!pq.isEmpty()) {
			int from = pq.peek().from;
			int to = pq.peek().to;
			int cost = pq.peek().cost;
			pq.poll();
			if (union(from, to)) {
//				System.out.println(from + "-" + to + ": "+ cost);
				result += cost;
			}
		}
		boolean isFull = true;
		int top = find(1);
		for (int i = 2; i < V + 1; i++) {
			if (find(i) != top) {
				isFull = false;
				break;
			}
		}

		result = totalCost - result;
		System.out.println(isFull ? result : -1);
	}

	static void make() {
		parents = new int[V + 1];
		for (int i = 0; i < V + 1; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;

		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[aRoot] = bRoot;
		return true;
	}
}
