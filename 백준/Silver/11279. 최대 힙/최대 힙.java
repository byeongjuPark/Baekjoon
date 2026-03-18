import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < N ; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pQ.peek() == null) {
					sb.append(0).append("\n");
				} else {
					sb.append(pQ.poll()).append("\n");
					
				}
			} else{
			
				pQ.add(num);
			}
		}
		System.out.println(sb.toString());
	}
}
