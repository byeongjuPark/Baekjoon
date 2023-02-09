class Solution {
    public String solution(String s, int n) {
        String answer = "";
        String split[] = s.split("");
        for(String str:split){
            if(str.charAt(0)==32){ // 공백
                answer+=str;
            }else if(str.charAt(0)<=90){ // 대문자
                if(str.charAt(0)+n <= 90){
                    char c = (char)(str.charAt(0) + n);
                    answer+=c;
                }else{//90이 2일때 66  90 - (26-2)
                    char c = (char)(str.charAt(0)-26+n);
                    answer+=c;
                }
            }else{ // 소문자
                if(str.charAt(0)+n <= 122){
                    char c = (char)(str.charAt(0) + n);
                    answer+=c;
                }else{//90이 2일때 66  90 - (26-2)
                    char c = (char)(str.charAt(0)-26+n);
                    answer+=c;
                }
            }
        }
        return answer;
    }
}