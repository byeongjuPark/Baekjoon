class Solution {
    public long solution(long num) {
        int answer = 0;
        while(true){
            if(num == 1){
                break;
            }
            answer++;
            
            if(num%2 == 0){
            num = num / 2;
            }else{
                num = num * 3 + 1;
            }
            
            if(num == 1){
                break;
            }
            if(answer == 500){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}