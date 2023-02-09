import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public String solution(int age) {
        String answer="";
        String str[] = String.valueOf(age).split("");
        for(String s : str){
            answer += String.valueOf((char)(s.charAt(0)+49));
        }
        return answer;
    }
}