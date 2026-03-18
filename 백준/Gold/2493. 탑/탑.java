import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Stack<int[]> stack = new Stack<>();
		int n;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			//  비어있지 않고, 맨 위가 temp보다 작으면 pop 반복
			while (!stack.isEmpty() && stack.peek()[1] < temp) {
				stack.pop();
			}

			// 스택 비어있으면 0
			if (stack.isEmpty()) {
				sb.append(0 + " ");
			} else {
				// 
				sb.append(stack.peek()[0]+" ");
			}
			// 값 넣기
			stack.push(new int[] { i + 1, temp });
		}
		System.out.println(sb.toString());

	}
}
