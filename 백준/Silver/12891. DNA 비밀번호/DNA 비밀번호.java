
import java.util.*;
import java.io.*;

public class Main {
	static int optionA;
	static int optionC;
	static int optionG;
	static int optionT;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		char[] DNA = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		optionA = Integer.parseInt(st.nextToken());
		optionC = Integer.parseInt(st.nextToken());
		optionG = Integer.parseInt(st.nextToken());
		optionT = Integer.parseInt(st.nextToken());

		int A = 0;
		int C = 0;
		int G = 0;
		int T = 0;

		// start
		// 첫구간합
		for (int i = 0; i < p; i++) {
			switch (DNA[i]) {
			case 'A':
				A++;
				break;
			case 'C':
				C++;
				break;
			case 'G':
				G++;
				break;
			case 'T':
				T++;
				break;
			}
		}
		int result = 0;
		if (canPassword(A, C, G, T)) {
			result++;
		}

		// sliding
		for (int i = 1; i <= s - p; i++) {
			switch (DNA[i - 1]) {
			case 'A':
				A--;
				break;
			case 'C':
				C--;
				break;
			case 'G':
				G--;
				break;
			case 'T':
				T--;
				break;
			}
			switch (DNA[i + p - 1]) {
			case 'A':
				A++;
				break;
			case 'C':
				C++;
				break;
			case 'G':
				G++;
				break;
			case 'T':
				T++;
				break;
			}
			
			if(canPassword(A, C, G, T)) {
				result++;
			}
		}
		System.out.println(result);
	}

	static boolean canPassword(int A, int C, int G, int T) {
		if (A >= optionA && C >= optionC && G >= optionG && T >= optionT) {
			return true;
		} else {
			return false;
		}
	}

}
