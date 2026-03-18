
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> has = new HashSet<Integer>();
		for(int i = 0; i < N; i++) {
			has.add(Integer.parseInt(st.nextToken()));
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(has.contains(n)) {
				sb.append("1");
			} else {
				sb.append("0");
			}
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}
}
