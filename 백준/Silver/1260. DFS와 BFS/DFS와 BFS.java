
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, start, adjMatrix[][];
	static boolean[] visited;
	static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		adjMatrix = new int[N+1][N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adjMatrix[a][b] = adjMatrix[b][a] = 1; 
		}
		
		
	}
	
	static void start() {
		visited = new boolean[N+1];
		dfs(start);
		System.out.println();
		visited = new boolean[N+1];
		bfs(start);
	}
	
	static void dfs(int start) {
		if(visited[start]) return;
		
		System.out.print(start + " ");
		visited[start] = true;
		
		
		
		for(int i = 1; i <= N; i++) {
			if(adjMatrix[start][i] == 1 && !visited[i] )  {
				dfs(i);
			}
		}
	}
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for(int i = 1; i <= N; i++) {
				if(adjMatrix[cur][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		init();
		start();
	}
}
