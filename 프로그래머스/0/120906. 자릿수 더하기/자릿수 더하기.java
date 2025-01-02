class Solution {
    public int solution(int n) {
        return String.valueOf(n).chars()
            .map(ch -> (int)(ch - '0'))
            .sum();
    }
}