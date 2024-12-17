import java.util.stream.*;
class Solution {
    public int solution(int[] numbers, int n) {
        int acc = 0;
        for (int i = 0 ; i < numbers.length ; i++)
        {
            acc += numbers[i];
            if(acc>n)
                return acc;
        }
        return acc;
    }
}