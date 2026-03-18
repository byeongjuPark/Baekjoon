import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException{
		Deque<Integer> deque = new ArrayDeque<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			String[] command = br.readLine().split(" ");
			if(command[0].equals("push")) {
				deque.add(Integer.parseInt(command[1]));
			} else if(command[0].equals("pop")) {

				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollFirst()).append("\n");
				}
			} else if(command[0].equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if(command[0].equals("empty")) {
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if(command[0].equals("front")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.getFirst()).append("\n");
				}
			} else if(command[0].equals("back")) {
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.getLast()).append("\n");
				}
			}
			
		}
        System.out.println(sb);
	}
}
