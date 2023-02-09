import java.util.ArrayList;
import java.util.List;
class Solution {
    public long[] solution(int x, int n) {
        List<Long> list = new ArrayList();
        for(int i = 0; i<n ; i++){
            list.add((x+(Long.valueOf(x)*i)));
        }
        long[] answer = list.stream().mapToLong(Long::valueOf).toArray();
        return answer;
    }
}