
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static String input;
	static String bomb;
	public static void main(String[] args) throws IOException{
		init();
		start();
	}
	static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		bomb = br.readLine();
	}
	static void start() {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
			if(stack.size()>= bomb.length()) {
				boolean flag = true;
				
				for(int j = 0; j < bomb.length(); j++) {
					if(stack.get(stack.size()- bomb.length()+j) != bomb.charAt(j)) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					for(int j = 0; j < bomb.length(); j++) stack.pop();
				}
			}
		}
		if(stack.isEmpty()) System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			for(Character c : stack) sb.append(c);
			System.out.println(sb);
		}
	}
}

