class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int discount =0;
        answer = (n*12000) + (k*2000);
        discount = n/10;
        answer = answer - (discount * 2000);
        return answer;
    }
}