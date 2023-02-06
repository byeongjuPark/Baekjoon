import java.util.List;
import java.util.ArrayList;
class Solution {
    public int[] solution(String my_string) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        String strArr[] = my_string.replaceAll("[a-zA-z]", "").split("");
        for(String str : strArr){
            list.add(Integer.parseInt(str));
        }
        answer = list.stream().mapToInt(i->i).sorted().toArray();
        return answer;
    }
}