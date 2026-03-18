
import java.io.*;
import java.util.*;

public class Main {
	private static int S, P;
	private static String s;
	private static int A, C, G, T;
	private static int A_, C_, G_, T_;
	private static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		s = new StringTokenizer(br.readLine()).nextToken();
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		// 구간 합 
		// 0 ~ (P-1) 까지의 구간 합 
		for(int i = 0; i < P; i++) {
			add(s.charAt(i));
		}
		
		// 슬라이딩 윈도우 
		// 첫번째(최초 구간합)케이스 카운트 
		if(canPassword()) result++;
		// 0 ~ S-P-1 만큼 이동 
		for(int i = 0; i < S-P; i++) {
			// i번째를 빼고, i+P-1 번째를 구간합에 더한다. 
			remove(s.charAt(i));
			add(s.charAt(i+P));
			if(canPassword()) result++;
		}
		
		System.out.println(result);
		
	}
	private static void remove(char c) {
		switch (c) {
		case 'A':
			A_--;
			break;
		case 'C':
			C_--;
			break;
		case 'G':
			G_--;
			break;
		case 'T':
			T_--;
			break;
		}
	}
	private static void add(char c) {
		switch (c) {
		case 'A':
			A_++;
			break;
		case 'C':
			C_++;
			break;
		case 'G':
			G_++;
			break;
		case 'T':
			T_++;
			break;
		}
	}
	private static boolean canPassword() {
		return A_>=A && C_>=C && G_>=G && T_>=T;
	}
}
