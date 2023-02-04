import java.util.*;
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        List list = new ArrayList();
        for(int a : sides){
            list.add(a);
        }
        list.sort(null);
        if(((int)list.get(0)+(int)list.get(1))>(int)list.get(2)){
            return 1;
        }else return 2;

    }
}