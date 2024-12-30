class Solution {
    public int solution(int n) {
        int cnt = 0;
        for(int i = 1 ; i < n*6 ; i++)
        {
            if(6*i % n == 0){
                cnt = i;
                break;
            }
        }
        return cnt;
    }
}