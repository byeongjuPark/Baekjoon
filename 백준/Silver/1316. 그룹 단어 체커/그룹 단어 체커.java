
import java.io.*;
import java.util.*;

public class Main {

	static int[] board;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	String[] arr = new String[N];
    	for(int i = 0; i < N; i++) {
    		arr[i] = br.readLine();
    	}
    	int cnt = 0;
    	for(String s : arr) {
    		if(groupWordCheck(s)) {
    			cnt++;
    		}
    	}
    	System.out.println(cnt);
    }
    
    static boolean groupWordCheck(String word) {
    	board = new int[26+1];
    	char beforeChar = word.charAt(0);
    	board[(word.charAt(0) - 'a' + 1)] = 1;
    	for(int i = 0; i < word.length(); i++) {
    		if(beforeChar != word.charAt(i)) {
    			if(board[(word.charAt(i) - 'a' + 1)] != 0) return false;
    			else board[(word.charAt(i) - 'a' + 1)]++;
    		}
    		beforeChar =word.charAt(i);
    	}
    	return true;
    }

}
