
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<String>();
		while(true) {
			String temp = br.readLine();
			if(temp.equals(".")) break;
			list.add(temp);
		}
		
		for(String str : list) {
			if(process(str)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
		
	}
	
	static boolean process(String str) {
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char c : arr) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
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
