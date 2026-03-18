
import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, i+1);
			list.add(str);
		}
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			boolean digit = false;
			char[] charArr = str.toCharArray();
			for(int d = 0; d < charArr.length; d++) {
				if(Character.isDigit(charArr[d])) {
					digit = true;
				} else {
					digit = false;
					break;
				}
			}
			if(digit) {
				int a = Integer.parseInt(str);
				System.out.println(list.get(a-1));
			} else {
				System.out.println(map.get(str));
			}
		}
	}
}
