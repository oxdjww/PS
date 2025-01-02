import java.util.stream.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        return IntStream.range(0, numlist.length)
            .filter(idx -> numlist[idx] % n == 0)
            .map(idx -> numlist[idx])
            .toArray();
    }
}