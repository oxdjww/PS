import java.util.stream.*;
class Solution {
    public int solution(int n) {
        return countDivNum(n);
    }
    private int countDivNum(int num)
    {
        int cnt = 0;
        for(int i = 1 ; i * i <= num ; i++) {
            if (i * i == num) cnt++;
            else if (num % i == 0) cnt += 2;
        }
        return cnt;
    }
}