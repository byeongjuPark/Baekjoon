

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static Map<String, String> storage = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pw = st.nextToken();
			storage.put(site, pw);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String site = br.readLine();
			sb.append(storage.get(site)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
