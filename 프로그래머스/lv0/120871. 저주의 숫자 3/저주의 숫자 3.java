import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int n) {
        List<Integer> list = new ArrayList();
        for(int i=0; i<200;i++){
            if(i%3!=0 &&!String.valueOf(i).contains("3")){
                list.add(i);
            }
        }
        return list.get(n-1);
    }
}