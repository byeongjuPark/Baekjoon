class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt =0;
        int yCnt =0;
        String str[] = s.split("");
        for(String st : str){
            if(st.equals("p")||st.equals("P")){
                pCnt++;
            }else if(st.equals("y")||st.equals("Y")){
                yCnt++;
            }
        }
        if(pCnt != yCnt){
            answer = false;
        }

        return answer;
    }
}