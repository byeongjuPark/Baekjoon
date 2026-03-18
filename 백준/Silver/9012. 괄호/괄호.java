
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<String>();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++){
			String temp = br.readLine();
			list.add(temp);
		}
		
		for(String str : list) {
			if(process(str)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}
	
	static boolean process(String str) {
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : arr) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
		
		if(stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
