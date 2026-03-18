import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		make();
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a == 1) {
					union(i, j);
				}
			}
		}
		boolean result = true;
		st = new StringTokenizer(br.readLine());
		int temp = 0; 
		for(int i = 1; i <= M; i++) {
			int v = Integer.parseInt(st.nextToken());
			if(i==1) temp = find(v);
			if(find(v) != temp) {
				result = false;
			}
		}
		System.out.println(result ? "YES":"NO");
	}
	
	static void make(){
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
		parents[bRoot] = aRoot;
		return true;
	}
}
