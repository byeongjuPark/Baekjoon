import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		TreeSet<String> resultSet = new TreeSet<>();
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if(set.contains(temp)) {
				cnt++;	
				resultSet.add(temp);
			}
		}
		for(String s : resultSet) {
			sb.append(s).append("\n");
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}
