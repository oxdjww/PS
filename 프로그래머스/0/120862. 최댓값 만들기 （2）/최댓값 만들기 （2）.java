import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int positiveMax = numbers[numbers.length-1]*numbers[numbers.length-2];
        int negativeMax = numbers[0]*numbers[1];
        return Math.max(positiveMax, negativeMax);
    }
}