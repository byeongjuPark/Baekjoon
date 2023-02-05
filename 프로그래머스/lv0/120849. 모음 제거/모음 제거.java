class Solution {
    public String solution(String my_string) {
        String answer = "";
        String strArr[] = my_string.split("");
        for(String str : strArr){
            if(str.equals("a")||str.equals("e")||str.equals("i")||str.equals("o")||str.equals("u")){
            
        }else{
            answer += str;
        }
    
    }
        return answer;
}
}