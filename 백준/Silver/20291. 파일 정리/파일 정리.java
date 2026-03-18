
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static class File implements Comparable<File>{
		int cnt;
		String fileName;
		File(int cnt, String fileName){
			this.cnt = cnt;
			this.fileName = fileName;
		}
		
		@Override
		public int compareTo(File f) {
			return this.fileName.compareTo(f.fileName);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Map<String, File> map = new HashMap<>();
		
		for(int i = 0 ; i < N; i++) {
			String str = br.readLine();
			String arr[] = str.split("\\.");
			String file = arr[1];
			map.putIfAbsent(file, new File(0, file));
			map.get(file).cnt++;
		}
		PriorityQueue<File> pq = new PriorityQueue<>();
		map.forEach((k, v) -> pq.offer(v));
		while(!pq.isEmpty()) {
			File cur = pq.poll();
			System.out.println(cur.fileName+ " " + cur.cnt);
		}
	}
}
