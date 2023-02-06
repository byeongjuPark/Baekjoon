import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for(int i : numlist){
            if(i%n == 0){
                list.add(i);
            }
        }
        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}