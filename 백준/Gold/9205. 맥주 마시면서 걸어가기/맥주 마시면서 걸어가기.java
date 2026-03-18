

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Vertex{
		int x, y;
		Vertex(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int T, N;
	static Vertex[] vertices;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			vertices = new Vertex[N+2];
			st = new StringTokenizer(br.readLine());
			vertices[0] = new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				vertices[i] = new Vertex(x, y);
			}
			st = new StringTokenizer(br.readLine());
			vertices[N+1] = new Vertex(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			System.out.println(bfs(0) ? "happy" : "sad");
		}
		
	}
	
	private static boolean bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		boolean[] visited = new boolean[N+2];
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			if(visited[cur]) continue;
			if(cur == N+1) return true;
			
//			System.out.print(cur +" ");
			
			visited[cur] = true;
			
			for(int i = 0 ; i < N+2; i++) {
				if(visited[i]) continue;
				Vertex next = vertices[i];
				int distance = getDistance(vertices[cur], next);
				if(distance <= 1000) q.offer(i);
			}
		}
		
		
		return false;
	}

	static int getDistance(Vertex v1, Vertex v2) {
		return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
	}
	
}
