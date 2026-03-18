
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[] str;      
	static boolean[] selected;
	static char[] result;   
	static int cnt, num;
	static boolean found; 

	// 순열의 총 개수는 n!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String input;

		while ((input = br.readLine()) != null) {
			st = new StringTokenizer(input, " ");
			if (st.countTokens() == 0) break;
			num = 0;
			str = st.nextToken().toCharArray();  
			cnt = Integer.parseInt(st.nextToken());
			if (factorial(str.length) < cnt) {
				System.out.println(new String(str) + " " + cnt + " = No permutation");
			} else {
				selected = new boolean[str.length];
				result = new char[str.length];  
				found = false; 
				permutation(0); 
				if (!found) {
					System.out.println(new String(str) + " " + cnt + " = No permutation");
				}
			}
		}
	}

	static int factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	static void permutation(int depth) {
		if (found) return;  

		if (depth == str.length) {
			num++;
			if (num == cnt) {
				System.out.println(new String(str) + " " + cnt + " = " + new String(result));
				found = true; 
			}
		} else {
			for (int i = 0; i < str.length; i++) {
				if (selected[i]) continue;
				selected[i] = true;
				result[depth] = str[i]; 
				permutation(depth + 1);
				selected[i] = false;
			}
		}
	}
}
