class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int zeroCnt = 0;
        int winCnt = 0;
        int max, min;
        for(int i = 0; i < 6 ; i++){
            if(lottos[i] == 0){
                    zeroCnt++;
                    continue;
                }
            for(int j = 0; j <6 ; j++){
                if(lottos[i] == win_nums[j]){
                    winCnt++;
                }
            }
        }
        max = zeroCnt + winCnt;
        min = winCnt;
        if(min == 0){
            min = min + 1;
        }
        if(max == 0){
            max = max + 1;
        }
        answer[0] = 7 - max;
        answer[1] = 7 - min;
        return answer;
    }
}