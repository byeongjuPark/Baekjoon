import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], islandNum;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static PriorityQueue<Edge> edges;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 번호 부여
		islandNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					islandNum++;
					floodFill(i, j);
				}
			}
		}

		// edge 추출
		edges = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					findEdge(i,j,map[i][j]);
				}
			}
		}
		make();
		int result = 0;
		while(!edges.isEmpty()) {
			Edge cur = edges.poll();
			if(union(cur)) {
				result += cur.weight;
//				System.out.println(cur.toString());
			}
		}
		
		// 모든 섬이 연결되었는지 검사
		int root = find(2); // 첫번째 루트
		boolean allIslandConnected = true;
		for(int i = 2; i < parents.length; i++) {
			if(root != find(i)) allIslandConnected = false;
		}
		
		
//		for(int i = 0; i < N; i++) {	
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		System.out.println(allIslandConnected?result : -1);
//		System.out.println(Arrays.toString(parents));
	}

	// 유니온 파인드
	static void make() {
		parents = new int[islandNum+1]; // 최대 섬 개수 6개
		for(int i = 0; i < islandNum+1; i++) parents[i] = i;
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return find(parents[a]);
	}
	
	static boolean union(Edge e) {
		int aRoot = find(e.from);
		int bRoot = find(e.to);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	// 4방 탐색으로 0이 있는 방향으로 나아가서 다음 섬 도달 시 Edge 찾음
	static void findEdge(int r, int c, int from) {
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(isBoundery(nr, nc) && map[nr][nc] == 0) {
				// 경계 안이고 나아갈 곳을 찾았다면.
				boolean flag = true; // 다음 섬을 만나면 false
				int len = 0;
				int gr = nr;
				int gc = nc;
				while(flag) {
					if(!isBoundery(gr, gc)) break; 
					if(map[gr][gc] != 0 && map[gr][gc] != from && len >= 2) {
						edges.add(new Edge(from, map[gr][gc], len));
						break;
					}
					if (map[gr][gc] != 0) break; // 같은 섬 또는 다른 섬 만나면 종료
					gr += dr[d];
					gc += dc[d];
					len++;
				}
			}
		}
	}

	static void floodFill(int r, int c) {
		if (map[r][c] == 0 || map[r][c] != 1)
			return;
		if (map[r][c] == islandNum)
			return;
		
		map[r][c] = islandNum;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (isBoundery(nr, nc)) {
				floodFill(nr, nc);
			}

		}
		
	}

	static boolean isBoundery(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
}
