import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			int command = Integer.parseInt(br.readLine());
			if(command == 0) {
				if(pQ.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(pQ.poll());
				}
			} else {
				pQ.offer(command);
			}
		}
	}
}
