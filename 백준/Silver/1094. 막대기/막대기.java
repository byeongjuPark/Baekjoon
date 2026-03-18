import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stick = 64;
		int count = 0;
		try {
			int input = Integer.parseInt(br.readLine());
			while(input > 0) {
				if(stick > input) {
					stick /= 2;
				} else { 
					input -= stick;
					count++;
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
	}
}