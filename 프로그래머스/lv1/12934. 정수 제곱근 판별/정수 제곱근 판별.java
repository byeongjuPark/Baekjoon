class Solution {
    public long solution(long n) {
        return Math.sqrt(n)%1 !=0 ? -1:(long)((Math.sqrt(n)+1)*(Math.sqrt(n)+1));
    }
}