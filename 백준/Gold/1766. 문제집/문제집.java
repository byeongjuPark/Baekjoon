import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M, edgeCnt[];
	static class Edge {
		int from;
		int to;
		public Edge(int from, int to){
			this.from = from;
			this.to = to;
		}
	
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeCnt = new int[N+1];
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		for(int i = 0; i < N+1; i++) {
			edges.add(new ArrayList<>());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edges.get(from).add(to);
			edgeCnt[to]++;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i = 1; i < N+1; i++) {
			if(edgeCnt[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(Integer e: edges.get(cur)){
				edgeCnt[e]--;
				if(edgeCnt[e] == 0) {
					q.add(e);
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
