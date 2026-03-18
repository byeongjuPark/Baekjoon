import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int[] parents;
	static int V, E;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		make();
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		// 1번 컴퓨터의 부모
		int computer1 = find(1);
		int cnt = 0;
		for(int i = 2; i < V+1; i++) {
			if(computer1 == find(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static void make() {
		parents = new int[V+1];
		for(int i = 0; i < V+1; i++) {
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
		parents[bRoot] = aRoot;
		return true;
	} 
}
