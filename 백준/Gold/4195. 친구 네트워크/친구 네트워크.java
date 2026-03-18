
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int T, F, N, parents[], size[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t =0; t< T; t++) {
			F = Integer.parseInt(br.readLine());
			HashSet<String> set = new HashSet<String>();
			String[][] rel = new String[F][2];
			for(int f = 0; f < F; f++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String a = st.nextToken();
				String b = st.nextToken();
				rel[f][0] = a;
				rel[f][1] = b;
				set.add(a);
				set.add(b);
			}
			N = set.size();
			// 해쉬맵으로 값 부여 
			int cnt = 1;
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			for(String s : set) {
				map.put(s, cnt);
				cnt++;
			}
			make();
			for(int i = 0; i < F; i++) {
				int a = map.get(rel[i][0]);
				int b = map.get(rel[i][1]);
				int aRoot = find(a);
                int bRoot = find(b);
                union(aRoot, bRoot);
                sb.append(size[find(aRoot)]).append("\n"); // 루트의 사이즈를 출력
			}
		
		}
		
		
		
		System.out.println(sb);
		
	}
	
	static void make() {
		parents = new int[N+1];
		size = new int[N+1];
		Arrays.fill(size, 1);
		for(int i = 0; i < N+1;i++) {
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
		if (size[aRoot] < size[bRoot]) {
            parents[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
        } else {
            parents[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
        }
		return true;
	}
}
