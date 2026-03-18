
import java.util.*;
import java.io.*;

public class Main{
	static List<Integer> list;
	static int n;
	static int x;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		x = Integer.parseInt(br.readLine());
		
		// 정렬
		Collections.sort(list);
		
		int result = 0;
		int start = 0;
		int end = n-1;
		while(start < end) {
			int a = list.get(start);
			int b = list.get(end);
			int sum = a + b;
			if(sum == x) { // 찾으면 결과누적, 
				result++;
				start++;
				end--;
			} else if(sum < x) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(result);
	}
	
}
