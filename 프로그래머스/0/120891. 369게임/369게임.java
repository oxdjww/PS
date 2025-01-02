class Solution {
    public int solution(int order) {
        int cnt = 0;
        while(order > 0)
        {
            if(order % 10 % 3 == 0 && order % 10 != 0){
                cnt++;
            }
            order /= 10;
        }
        return cnt;
    }
}