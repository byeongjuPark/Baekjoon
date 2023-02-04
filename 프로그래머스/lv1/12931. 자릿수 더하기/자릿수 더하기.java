import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);
        String strArr[] = str.split("");
        for(String s : strArr){
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}