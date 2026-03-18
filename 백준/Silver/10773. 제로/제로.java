import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> s = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if(temp == 0) {
				s.pop();
			} else {
				s.add(temp);
			}
		}
		int result = 0;
		int size = s.size();
		for(int i = 0; i < size; i++) {
			int temp = s.pop();
			result+= temp;
			
		}
		System.out.println(result);
		
	}
}
