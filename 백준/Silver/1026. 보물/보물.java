
import java.util.*;
import java.io.*;

public class Main{
	static List<Integer> A;
	static List<Integer> B;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new ArrayList<>();
		B = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) A.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) B.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(A, Collections.reverseOrder());
		Collections.sort(B);
		int result = 0;
		for(int i = 0; i < N; i++) {
			int a = A.get(i);
			int b = B.get(i);
			result += (a*b);
		}
		System.out.println(result);
	}
}
