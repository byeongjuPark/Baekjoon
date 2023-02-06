class Solution {
    public String solution(String my_string) {
        String answer = "";
        String strArr[] = my_string.split("");
        for(String str : strArr){
            if((int)str.charAt(0)<97){
                answer+=(char)(str.charAt(0) + 32);
            }else{
                answer+=(char)(str.charAt(0) - 32);
            }
        }
        return answer;
    }
}