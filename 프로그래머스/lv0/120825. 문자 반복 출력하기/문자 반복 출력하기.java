class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String splitStr[] = my_string.split("");
        
        for(int k = 0; k<splitStr.length; k++){
            String strTemp = null;
            for(int i = 0; i<n; i++){
                strTemp += splitStr[k];
            }
            splitStr[k] = strTemp.replace("null", "");

        }
        
        answer = String.join("",splitStr);
        return answer;
    }
}