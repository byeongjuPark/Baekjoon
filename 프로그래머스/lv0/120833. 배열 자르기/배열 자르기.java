import java.util.ArrayList;
import java.util.List;

class Solution {
    public List solution(int[] numbers, int num1, int num2) {

        List list = new ArrayList<>();
        
        for(int i=num1; i<num2+1; i++){
            list.add(numbers[i]);
        }

        return list;
    }
}