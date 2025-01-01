class Solution {
    public int solution(int n) {
        int result = 1;
        int i = 1;
        while(result <= n)
        {
            result *= ++i;
        }
        return i-1;
    }
}