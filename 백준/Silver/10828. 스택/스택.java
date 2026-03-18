
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case "pop":
				if(stack.size() != 0) {
					System.out.println(stack.pop());
				} else {
					System.out.println("-1");
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			
			case "empty":
				if(stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "top":
				if(stack.size() != 0) {
					System.out.println(stack.peek());
				} else {
					System.out.println("-1");
				}
				break;
			}
		}
		
	}
	
}
