class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int index = 0;
        for(String str : seoul){
            if(str.equals("Kim")){
                answer = "김서방은 "+index+"에 있다";
            }
            index++;
        }
        return answer;
    }
}