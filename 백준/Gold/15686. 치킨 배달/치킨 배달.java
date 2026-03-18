import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N, M; // map의 크기, 치킨집 최대 M개
	static int V, chSize, chList[], min;
	static boolean visited[];
	static int[] parents;
	static ArrayList<int[]> h, ch;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		h = new ArrayList<>();
		ch  = new ArrayList<>();
		for(int i = 1 ; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 1) h.add(new int[] {i, j});
				if(temp == 2) ch.add(new int[] {i, j});
			}
		}
		V = h.size() + ch.size();
		chSize = ch.size();
		chList = new int[M];
		visited = new boolean[M];
		min = Integer.MAX_VALUE;
		combi(0, 0);
		System.out.println(min);
		
	}
	
	static void combi(int cnt, int start) {
		if(cnt == M) {
//			System.out.println(Arrays.toString(chList));
			int tempMin = 0;
			for(int[] home : h) {
				int tempMinDistance = Integer.MAX_VALUE;
				for(int a : chList) {
					tempMinDistance = Math.min(tempMinDistance, getDistance(home, ch.get(a)));
				}
				tempMin += tempMinDistance;
			}
			min = Math.min(tempMin, min);
			return;
		}
		for(int i = start; i < chSize; i++) {
			chList[cnt] = i;
			combi(cnt+1, i+1);
		}
	}
	
	static int getDistance(int[] a, int[] b) {
		return Math.abs(a[0]- b[0]) + Math.abs(a[1]-b[1]);
	}

}
