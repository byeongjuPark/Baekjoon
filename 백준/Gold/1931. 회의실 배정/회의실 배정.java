
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			
		}
		Collections.sort(list, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                }
				return Integer.compare(o1[1], o2[1]);
			}
			
		});
		int cnt = 0;
		int endTime = 0;
		for(int[] time : list) {
			if(time[0] >= endTime) {
				cnt++;
				endTime = time[1];
			}
		}
		System.out.println(cnt);

	}
}
