
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, edgeCnt[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeCnt = new int[V + 1];
		List<int[]> list = new ArrayList<>();
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			edgeCnt[to]++;
		}

		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 1; i < V+1; i++) {
			if (edgeCnt[i] == 0) {
				q.add(new int[] { i, 1 });
			}
		}
		while (!q.isEmpty()) {
			int cur = q.peek()[0];
			int depth = q.peek()[1];
			q.poll();
			
			list.add(new int[] { cur, depth });

			for (int next : graph.get(cur)) {
				edgeCnt[next]--;
				if (edgeCnt[next] == 0) {
					q.add(new int[] { next, depth + 1 });	
				}
			}
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(Arrays.toString(list.get(i)));
//		}
		int[] result = new int[V+1];
		for(int[] a : list) {
			// 0 > V
			// 1 > R
			result[a[0]] = a[1];
		}
		for(int i = 1; i < V+1; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
}
