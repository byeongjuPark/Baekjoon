import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int sortedArr[] = Arrays.stream(numbers).sorted().toArray();
        answer = sortedArr[sortedArr.length-1] * sortedArr[sortedArr.length-2];
        return answer;
    }
}