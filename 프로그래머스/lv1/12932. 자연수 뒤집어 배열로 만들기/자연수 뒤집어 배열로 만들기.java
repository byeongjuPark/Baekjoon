class Solution {
    public int[] solution(long n) {
        String str = new StringBuilder(String.valueOf(n)).reverse().toString();
        String[] strArr = str.split("");
        int[] answer = new int[strArr.length];
        for(int i = 0 ; i<answer.length; i++){
            answer[i] = Integer.parseInt(strArr[i]);
        }
        return answer;
    }
}